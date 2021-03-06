package com.dgsoft.house.owner.total;

import com.dgsoft.common.system.DictionaryWord;
import com.dgsoft.common.system.SystemEntityLoader;
import com.dgsoft.common.system.business.BusinessInstance;
import com.dgsoft.common.system.model.Word;
import com.dgsoft.house.HouseEntityLoader;
import com.dgsoft.house.SaleType;
import com.dgsoft.house.model.Project;
import com.dgsoft.house.model.Section;
import com.dgsoft.house.owner.OwnerEntityLoader;
import com.dgsoft.house.owner.model.BusinessEmp;
import com.dgsoft.house.owner.model.ContractOwner;
import com.dgsoft.house.owner.model.OwnerBusiness;
import com.dgsoft.house.owner.total.data.BusinessTotalData;
import com.dgsoft.house.owner.total.data.TotalContractData;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.international.StatusMessage;
import org.jboss.seam.log.Logging;
import sun.swing.SwingUtilities2;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by wxy on 2015-11-16.
 * 商品房备案业务明细，签约和正常备案
 */
@Name("totalContract")
public class TotalContract {

    public static  class  DeveloperGroup<T extends SectionItem>{

        private String name;

        private Map<String,T> sectionMap = new HashMap<String,T>();

        public void putData(TotalContractData data,boolean home,Class<T> c) throws IllegalAccessException, InstantiationException {
            Logging.getLog(getClass()).debug(data.getBusinessDefineId());
            name = data.getDeveloperName();
            T pitem = sectionMap.get(data.getSectionName());
            if (pitem == null){
                pitem = c.newInstance();
                sectionMap.put(data.getSectionName(),pitem);
            }
            pitem.putData(data,home);

        }

        public String getName() {
            return name;
        }

        Map<String, T> getSectionMap() {
            return sectionMap;
        }

        public List<T> getSectionItems(){
            List<T> result = new ArrayList<T>(getSectionMap().values());
            Collections.sort(result, new Comparator<SectionItem>() {
                @Override
                public int compare(SectionItem o1, SectionItem o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            return result;
        }
    }

    public interface SectionItem{
         void putData(TotalContractData data, boolean home);

         String getName();
    }

    public static class SectionRecordTypeItem implements SectionItem{
        private String name;

        private TotalContractData saleNowHome;

        private TotalContractData saleNowUnHome;

        private TotalContractData salePrepareHome;

        private TotalContractData salePrepareUnHome;

        @Override
        public void putData(TotalContractData data, boolean home){
            name = data.getSectionName();
            if (home){
                if(SaleType.MAP_SELL.equals(data.getSaleType())){

                    salePrepareHome = data;
                }else{
                    saleNowHome = data;
                }

            }else{
                if(SaleType.MAP_SELL.equals(data.getSaleType())){
                    salePrepareUnHome = data;

                }else{
                    saleNowUnHome = data;
                }

            }
        }

        @Override
        public String getName() {
            return name;
        }

        public TotalContractData getSaleNowHome() {
            return saleNowHome;
        }

        public TotalContractData getSaleNowUnHome() {
            return saleNowUnHome;
        }

        public TotalContractData getSalePrepareHome() {
            return salePrepareHome;
        }

        public TotalContractData getSalePrepareUnHome() {
            return salePrepareUnHome;
        }
    }

    public static class SectionRecordItem implements SectionItem{

        private String name;

        private TotalContractData saleHome;

        private TotalContractData saleUnHome;

        private TotalContractData cancelHome;

        private TotalContractData cancelUnHome;

        private TotalContractData abortHome;

        private TotalContractData abortUnHome;

        @Override
        public void putData(TotalContractData data, boolean home){
            name = data.getSectionName();
            if (home){
                if(data.getBusinessDefineId().equals("WP42")){
                    if (data.getStatus().equals(BusinessInstance.BusinessStatus.ABORT)){
                        abortHome = data;
                    }else{
                        saleHome = data;
                    }

                }else{
                    cancelHome = data;
                }

            }else{
                if(data.getBusinessDefineId().equals("WP42")){
                    if (data.getStatus().equals(BusinessInstance.BusinessStatus.ABORT)){
                        abortUnHome = data;
                    }else{
                        saleUnHome = data;
                    }

                }else{
                    cancelUnHome = data;
                }

            }
        }

        public TotalContractData getAbortHome() {
            return abortHome;
        }

        public TotalContractData getAbortUnHome() {
            return abortUnHome;
        }

        @Override
        public String getName() {
            return name;
        }

        public TotalContractData getSaleHome() {
            return saleHome;
        }

        public TotalContractData getSaleUnHome() {
            return saleUnHome;
        }

        public TotalContractData getCancelHome() {
            return cancelHome;
        }

        public TotalContractData getCancelUnHome() {
            return cancelUnHome;
        }
    }


    @In(create = true)
    private OwnerEntityLoader ownerEntityLoader;


    @In(create = true)
    private FacesContext facesContext;

    @In(create = true)
    private FacesMessages facesMessages;

    private Date fromDateTime;


    private Date toDateTime;


    public Date getToDateTime() {
        return toDateTime;
    }

    public void setToDateTime(Date toDateTime) {
        this.toDateTime = toDateTime;
    }

    public Date getFromDateTime() {
        return fromDateTime;
    }

    public void setFromDateTime(Date fromDateTime) {
        this.fromDateTime = fromDateTime;
    }


    public List<String> getHouseUseType(String key){
        List<Word> words =DictionaryWord.instance().getWordList("house.useType");
        List<String> xzwords = new ArrayList<String>();
        for (Word word:words){
            if (word.getKey().equals(key)){
                xzwords.add(word.getId());
            }
        }
        return xzwords;
    }


    public void tatalContractBySellType(){

        List<TotalContractData> homeTotalData = ownerEntityLoader.getEntityManager().createQuery("select new com.dgsoft.house.owner.total.data.TotalContractData(hb.afterBusinessHouse.contractOwner.type,hb.afterBusinessHouse.developerName,hb.afterBusinessHouse.sectionName,count(hb.id),sum(hb.afterBusinessHouse.saleInfo.sumPrice),sum(hb.afterBusinessHouse.houseArea)) from HouseBusiness hb where hb.ownerBusiness.defineId = 'WP42' and hb.ownerBusiness.status = 'COMPLETE' " +
                " and hb.afterBusinessHouse.useType in (:usetype)  and hb.ownerBusiness.source in ('BIZ_CREATE','BIZ_IMPORT','BIZ_OUTSIDE') " +
                "and hb.ownerBusiness.regTime >= :beginDate and hb.ownerBusiness.regTime <= :endDate " +
                "group by  hb.afterBusinessHouse.contractOwner.type, hb.afterBusinessHouse.developerName,hb.afterBusinessHouse.sectionName ", TotalContractData.class)
                .setParameter("beginDate", fromDateTime)
                .setParameter("endDate", toDateTime)
                .setParameter("usetype",getHouseUseType("1")).getResultList();




        List<TotalContractData> unhomeTotalData =ownerEntityLoader.getEntityManager().createQuery("select new com.dgsoft.house.owner.total.data.TotalContractData(hb.afterBusinessHouse.contractOwner.type,hb.afterBusinessHouse.developerName,hb.afterBusinessHouse.sectionName,count(hb.id),sum(hb.afterBusinessHouse.saleInfo.sumPrice),sum(hb.afterBusinessHouse.houseArea)) from HouseBusiness hb where hb.ownerBusiness.defineId = 'WP42' and hb.ownerBusiness.status = 'COMPLETE' " +
                " and hb.afterBusinessHouse.useType not in (:usetype)  and hb.ownerBusiness.source in ('BIZ_CREATE','BIZ_IMPORT','BIZ_OUTSIDE') " +
                "and hb.ownerBusiness.regTime >= :beginDate and hb.ownerBusiness.regTime <= :endDate " +
                "group by  hb.afterBusinessHouse.contractOwner.type, hb.afterBusinessHouse.developerName,hb.afterBusinessHouse.sectionName ", TotalContractData.class)
                .setParameter("beginDate", fromDateTime)
                .setParameter("endDate", toDateTime)
                .setParameter("usetype",getHouseUseType("1")).getResultList();



        Map<String,DeveloperGroup<SectionRecordTypeItem>> resultData = new HashMap<String, DeveloperGroup<SectionRecordTypeItem>>();

        Logging.getLog(getClass()).debug("homeTotalData--"+homeTotalData.size());
        for(TotalContractData data: homeTotalData){
            DeveloperGroup<SectionRecordTypeItem> dg = resultData.get(data.getDeveloperName());
            if (dg == null){
                dg = new DeveloperGroup<SectionRecordTypeItem>();
                resultData.put(data.getDeveloperName(),dg);
            }
            try {
                dg.putData(data,true,SectionRecordTypeItem.class);
            } catch (IllegalAccessException e) {
                throw new IllegalArgumentException(e);
            } catch (InstantiationException e) {
                throw new IllegalArgumentException(e);
            }
        }
        Logging.getLog(getClass()).debug("unhomeTotalData--"+homeTotalData.size());
        for(TotalContractData data: unhomeTotalData){
            DeveloperGroup<SectionRecordTypeItem> dg = resultData.get(data.getDeveloperName());
            if (dg == null){
                dg = new DeveloperGroup<SectionRecordTypeItem>();
                resultData.put(data.getDeveloperName(),dg);
            }
            try {
                dg.putData(data,false,SectionRecordTypeItem.class);
            } catch (IllegalAccessException e) {
                throw new IllegalArgumentException(e);
            } catch (InstantiationException e) {
                throw new IllegalArgumentException(e);
            }
        }

        List<DeveloperGroup<SectionRecordTypeItem>> resultList = new ArrayList<DeveloperGroup<SectionRecordTypeItem>>(resultData.values());
        Collections.sort(resultList, new Comparator<DeveloperGroup<SectionRecordTypeItem>>() {
            @Override
            public int compare(DeveloperGroup<SectionRecordTypeItem> o1, DeveloperGroup<SectionRecordTypeItem> o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });


        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFCellStyle headCellStyle = workbook.createCellStyle();
        XSSFCellStyle cellStyle = workbook.createCellStyle();


        headCellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);//水平居中
        headCellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER); //垂直居中
        XSSFFont font = workbook.createFont();// 创建字体对象
        font.setFontHeightInPoints((short) 12);// 设置字体大小
        headCellStyle.setFont(font);

        int rowIndex = 0;//行

        XSSFSheet sheet = workbook.createSheet("备案信息统计");

        Row row1 = sheet.createRow(rowIndex++);
        Row row2 = sheet.createRow(rowIndex++);
        Row row3 = sheet.createRow(rowIndex++);


        Cell cell = row1.createCell(0);
        sheet.addMergedRegion(new CellRangeAddress(0, 2, 0, 0));
        cell.setCellValue("开发商名称");
        cell.setCellStyle(headCellStyle);


        cell = row1.createCell(1);
        sheet.addMergedRegion(new CellRangeAddress(0, 2, 1, 1));
        cell.setCellValue("小区名称");
        cell.setCellStyle(headCellStyle);

        cell = row1.createCell(2);
        sheet.addMergedRegion(new CellRangeAddress(0,0,2,7));
        cell.setCellValue("预售备案");
        cell.setCellStyle(headCellStyle);


        cell = row1.createCell(8);
        sheet.addMergedRegion(new CellRangeAddress(0,0,8,13));
        cell.setCellValue("现售备案");
        cell.setCellStyle(headCellStyle);



        cell = row2.createCell(2);
        sheet.addMergedRegion(new CellRangeAddress(1,1,2,4));
        cell.setCellValue("住宅");
        cell.setCellStyle(headCellStyle);

        cell = row2.createCell(5);
        sheet.addMergedRegion(new CellRangeAddress(1,1,5,7));
        cell.setCellValue("非住宅");
        cell.setCellStyle(headCellStyle);

        cell = row2.createCell(8);
        sheet.addMergedRegion(new CellRangeAddress(1,1,8,10));
        cell.setCellValue("住宅");
        cell.setCellStyle(headCellStyle);

        cell = row2.createCell(11);
        sheet.addMergedRegion(new CellRangeAddress(1,1,11,13));
        cell.setCellValue("非住宅");
        cell.setCellStyle(headCellStyle);



        int cellIndex = 2;
        for(int i = 0; i< 4; i++){
            cell = row3.createCell(cellIndex++);
            cell.setCellValue("套数");
            cell.setCellStyle(headCellStyle);

            cell = row3.createCell(cellIndex++);
            cell.setCellValue("面积");
            cell.setCellStyle(headCellStyle);

            cell = row3.createCell(cellIndex++);
            cell.setCellValue("购房款");
            cell.setCellStyle(headCellStyle);
        }


        for(DeveloperGroup<SectionRecordTypeItem> dg : resultList){
            int beginRow = rowIndex;

            Row row = null;
            for(SectionRecordTypeItem item : dg.getSectionItems()){
                cellIndex = 1;
                if (row == null){
                    row = sheet.createRow(rowIndex++);
                    cell = row.createCell(0);
                    cell.setCellValue(dg.getName());
                    cell.setCellStyle(headCellStyle);
                }else
                    row = sheet.createRow(rowIndex++);


                cell = row.createCell(cellIndex++);
                cell.setCellValue(item.getName());
                cell.setCellStyle(cellStyle);

                cell = row.createCell(cellIndex++);
                if (item.getSalePrepareHome() != null)
                    cell.setCellValue(item.getSalePrepareHome().getCount());
                    else
                    cell.setCellValue(0);

                cell.setCellStyle(cellStyle);

                cell = row.createCell(cellIndex++);
                if (item.getSalePrepareHome() != null)
                    cell.setCellValue(item.getSalePrepareHome().getHouseArea().doubleValue());
                else
                    cell.setCellValue(0);
                cell.setCellStyle(cellStyle);

                cell = row.createCell(cellIndex++);
                if (item.getSalePrepareHome() != null)
                    cell.setCellValue(item.getSalePrepareHome().getSumPrice().doubleValue());
                else
                    cell.setCellValue(0);
                cell.setCellStyle(cellStyle);

                cell = row.createCell(cellIndex++);
                if (item.getSalePrepareUnHome() != null)
                    cell.setCellValue(item.getSalePrepareUnHome().getCount());
                else
                    cell.setCellValue(0);
                cell.setCellStyle(cellStyle);

                cell = row.createCell(cellIndex++);
                if (item.getSalePrepareUnHome() != null)
                    cell.setCellValue(item.getSalePrepareUnHome().getHouseArea().doubleValue());
                else
                    cell.setCellValue(0);
                cell.setCellStyle(cellStyle);

                cell = row.createCell(cellIndex++);
                if (item.getSalePrepareUnHome() != null)
                    cell.setCellValue(item.getSalePrepareUnHome().getSumPrice().doubleValue());
                else
                    cell.setCellValue(0);
                cell.setCellStyle(cellStyle);


                cell = row.createCell(cellIndex++);
                if (item.getSaleNowHome() != null)
                    cell.setCellValue(item.getSaleNowHome().getCount());
                else
                    cell.setCellValue(0);
                cell.setCellStyle(cellStyle);

                cell = row.createCell(cellIndex++);
                if (item.getSaleNowHome() != null)
                    cell.setCellValue(item.getSaleNowHome().getHouseArea().doubleValue());
                else
                    cell.setCellValue(0);
                cell.setCellStyle(cellStyle);

                cell = row.createCell(cellIndex++);
                if (item.getSaleNowHome() != null)
                    cell.setCellValue(item.getSaleNowHome().getSumPrice().doubleValue());
                else
                    cell.setCellValue(0);
                cell.setCellStyle(cellStyle);

                cell = row.createCell(cellIndex++);
                if (item.getSaleNowUnHome() != null)
                    cell.setCellValue(item.getSaleNowUnHome().getCount());
                else
                    cell.setCellValue(0);
                cell.setCellStyle(cellStyle);

                cell = row.createCell(cellIndex++);
                if (item.getSaleNowUnHome() != null)
                    cell.setCellValue(item.getSaleNowUnHome().getHouseArea().doubleValue());
                else
                    cell.setCellValue(0);
                cell.setCellStyle(cellStyle);

                cell = row.createCell(cellIndex++);
                if (item.getSaleNowUnHome() != null)
                    cell.setCellValue(item.getSaleNowUnHome().getSumPrice().doubleValue());
                else
                    cell.setCellValue(0);
                cell.setCellStyle(cellStyle);



            }


            sheet.addMergedRegion(new CellRangeAddress(beginRow, rowIndex - 1, 0, 0));


        }






        row1 = sheet.createRow(rowIndex);
        Cell zzhjcell = row1.createCell(0);
        zzhjcell.setCellValue("合计");
        zzhjcell.setCellStyle(headCellStyle);
        cellIndex = 2;
        for(int i = 0; i< 4; i++){

            zzhjcell = row1.createCell(cellIndex++,Cell.CELL_TYPE_FORMULA);
            zzhjcell.setCellFormula("SUM(" + CellReference.convertNumToColString(cellIndex - 1) + "4:" + CellReference.convertNumToColString(cellIndex - 1)+rowIndex+")");
            zzhjcell.setCellStyle(headCellStyle);

            zzhjcell = row1.createCell(cellIndex++,Cell.CELL_TYPE_FORMULA);
            zzhjcell.setCellFormula("SUM(" + CellReference.convertNumToColString(cellIndex - 1) + "4:" + CellReference.convertNumToColString(cellIndex - 1)+rowIndex+")");
            zzhjcell.setCellStyle(headCellStyle);

            zzhjcell = row1.createCell(cellIndex++,Cell.CELL_TYPE_FORMULA);
            zzhjcell.setCellFormula("SUM(" + CellReference.convertNumToColString(cellIndex - 1) + "4:" + CellReference.convertNumToColString(cellIndex - 1)+rowIndex+")");
            zzhjcell.setCellStyle(headCellStyle);

        }






        sheet.setForceFormulaRecalculation(true);
        ExternalContext externalContext = facesContext.getExternalContext();
        externalContext.responseReset();
        externalContext.setResponseContentType("application/vnd.ms-excel");
        externalContext.setResponseHeader("Content-Disposition", "attachment;filename=exportContract.xlsx");
        try {
            workbook.write(externalContext.getResponseOutputStream());
            facesContext.responseComplete();
        } catch (IOException e) {
            facesMessages.addFromResourceBundle(StatusMessage.Severity.ERROR, "ExportIOError");
            Logging.getLog(getClass()).error("export error", e);

        }


    }

    public void totalContractInfo() {



        List<TotalContractData> homeTotalData = ownerEntityLoader.getEntityManager().createQuery("select new com.dgsoft.house.owner.total.data.TotalContractData(hb.ownerBusiness.status,hb.ownerBusiness.defineId,hb.afterBusinessHouse.developerName,hb.afterBusinessHouse.sectionName,count(hb.id),sum(hb.afterBusinessHouse.saleInfo.sumPrice),sum(hb.afterBusinessHouse.houseArea)) from HouseBusiness hb where hb.ownerBusiness.defineId in ('WP42','WP43') and hb.ownerBusiness.status in ('COMPLETE','ABORT') " +
                " and hb.afterBusinessHouse.useType in (:usetype)  and hb.ownerBusiness.source in ('BIZ_CREATE','BIZ_IMPORT','BIZ_OUTSIDE') " +
                "and hb.ownerBusiness.regTime >= :beginDate and hb.ownerBusiness.regTime <= :endDate " +
                "group by hb.ownerBusiness.status, hb.afterBusinessHouse.developerName,hb.afterBusinessHouse.sectionName,hb.ownerBusiness.defineId ", TotalContractData.class)
                .setParameter("beginDate", fromDateTime)
                .setParameter("endDate", toDateTime)
                .setParameter("usetype",getHouseUseType("1")).getResultList();


        List<TotalContractData> unhomeTotalData = ownerEntityLoader.getEntityManager().createQuery("select new com.dgsoft.house.owner.total.data.TotalContractData(hb.ownerBusiness.status,hb.ownerBusiness.defineId,hb.afterBusinessHouse.developerName,hb.afterBusinessHouse.sectionName,count(hb.id),sum(hb.afterBusinessHouse.saleInfo.sumPrice),sum(hb.afterBusinessHouse.houseArea)) from HouseBusiness hb where hb.ownerBusiness.defineId in ('WP42','WP43') and hb.ownerBusiness.status in ('COMPLETE','ABORT') " +
                " and hb.afterBusinessHouse.useType not in (:usetype) and hb.ownerBusiness.source in ('BIZ_CREATE','BIZ_IMPORT','BIZ_OUTSIDE') " +
                "and hb.ownerBusiness.regTime >= :beginDate and hb.ownerBusiness.regTime <= :endDate " +
                "group by hb.ownerBusiness.status, hb.afterBusinessHouse.developerName,hb.afterBusinessHouse.sectionName,hb.ownerBusiness.defineId ", TotalContractData.class)
                .setParameter("beginDate", fromDateTime)
                .setParameter("endDate", toDateTime)
                .setParameter("usetype",getHouseUseType("1")).getResultList();



        Map<String,DeveloperGroup<SectionRecordItem>> resultData = new HashMap<String, DeveloperGroup<SectionRecordItem>>();


        for(TotalContractData data: homeTotalData){
            DeveloperGroup<SectionRecordItem> dg = resultData.get(data.getDeveloperName());
            if (dg == null){
                dg = new DeveloperGroup<SectionRecordItem>();
                resultData.put(data.getDeveloperName(),dg);
            }
            try {
                dg.putData(data,true,SectionRecordItem.class);
            } catch (IllegalAccessException e) {
                throw new IllegalArgumentException(e);
            } catch (InstantiationException e) {
                throw new IllegalArgumentException(e);
            }
        }

        for(TotalContractData data: unhomeTotalData){
            DeveloperGroup<SectionRecordItem> dg = resultData.get(data.getDeveloperName());
            if (dg == null){
                dg = new DeveloperGroup<SectionRecordItem>();
                resultData.put(data.getDeveloperName(),dg);
            }
            try {
                dg.putData(data,false,SectionRecordItem.class);
            } catch (IllegalAccessException e) {
                throw new IllegalArgumentException(e);
            } catch (InstantiationException e) {
                throw new IllegalArgumentException(e);
            }
        }

        List<DeveloperGroup<SectionRecordItem>> resultList = new ArrayList<DeveloperGroup<SectionRecordItem>>(resultData.values());
        Collections.sort(resultList, new Comparator<DeveloperGroup<SectionRecordItem>>() {
            @Override
            public int compare(DeveloperGroup<SectionRecordItem> o1, DeveloperGroup<SectionRecordItem> o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFCellStyle headCellStyle = workbook.createCellStyle();
        XSSFCellStyle cellStyle = workbook.createCellStyle();


        headCellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);//水平居中
        headCellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER); //垂直居中
        XSSFFont font = workbook.createFont();// 创建字体对象
        font.setFontHeightInPoints((short) 12);// 设置字体大小
        headCellStyle.setFont(font);

        int rowIndex = 0;//行

        XSSFSheet sheet = workbook.createSheet("备案信息统计");

        Row row1 = sheet.createRow(rowIndex++);
        Row row2 = sheet.createRow(rowIndex++);
        Row row3 = sheet.createRow(rowIndex++);


        Cell cell = row1.createCell(0);
        sheet.addMergedRegion(new CellRangeAddress(0, 2, 0, 0));
        cell.setCellValue("开发商名称");
        cell.setCellStyle(headCellStyle);


        cell = row1.createCell(1);
        sheet.addMergedRegion(new CellRangeAddress(0, 2, 1, 1));
        cell.setCellValue("小区名称");
        cell.setCellStyle(headCellStyle);

        cell = row1.createCell(2);
        sheet.addMergedRegion(new CellRangeAddress(0,0,2,7));
        cell.setCellValue("商品房备案");
        cell.setCellStyle(headCellStyle);


        cell = row1.createCell(8);
        sheet.addMergedRegion(new CellRangeAddress(0,0,8,13));
        cell.setCellValue("撤消房备案");
        cell.setCellStyle(headCellStyle);

        cell = row1.createCell(14);
        sheet.addMergedRegion(new CellRangeAddress(0,0,14,19));
        cell.setCellValue("撤消签约");
        cell.setCellStyle(headCellStyle);


        cell = row2.createCell(2);
        sheet.addMergedRegion(new CellRangeAddress(1,1,2,4));
        cell.setCellValue("住宅");
        cell.setCellStyle(headCellStyle);

        cell = row2.createCell(5);
        sheet.addMergedRegion(new CellRangeAddress(1,1,5,7));
        cell.setCellValue("非住宅");
        cell.setCellStyle(headCellStyle);

        cell = row2.createCell(8);
        sheet.addMergedRegion(new CellRangeAddress(1,1,8,10));
        cell.setCellValue("住宅");
        cell.setCellStyle(headCellStyle);

        cell = row2.createCell(11);
        sheet.addMergedRegion(new CellRangeAddress(1,1,11,13));
        cell.setCellValue("非住宅");
        cell.setCellStyle(headCellStyle);

        cell = row2.createCell(14);
        sheet.addMergedRegion(new CellRangeAddress(1,1,14,16));
        cell.setCellValue("住宅");
        cell.setCellStyle(headCellStyle);

        cell = row2.createCell(17);
        sheet.addMergedRegion(new CellRangeAddress(1,1,17,19));
        cell.setCellValue("非住宅");
        cell.setCellStyle(headCellStyle);


        int cellIndex = 2;
        for(int i = 0; i< 6; i++){
            cell = row3.createCell(cellIndex++);
            cell.setCellValue("套数");
            cell.setCellStyle(headCellStyle);

            cell = row3.createCell(cellIndex++);
            cell.setCellValue("面积");
            cell.setCellStyle(headCellStyle);

            cell = row3.createCell(cellIndex++);
            cell.setCellValue("购房款");
            cell.setCellStyle(headCellStyle);
        }


        for(DeveloperGroup<SectionRecordItem> dg : resultList){
            int beginRow = rowIndex;

            Row row = null;
            for(SectionRecordItem item : dg.getSectionItems()){
                cellIndex = 1;
                if (row == null){
                    row = sheet.createRow(rowIndex++);
                    cell = row.createCell(0);
                    cell.setCellValue(dg.getName());
                    cell.setCellStyle(headCellStyle);
                }else
                    row = sheet.createRow(rowIndex++);


                cell = row.createCell(cellIndex++);
                cell.setCellValue(item.getName());
                cell.setCellStyle(cellStyle);

                cell = row.createCell(cellIndex++);
                if (item.getSaleHome() != null)
                cell.setCellValue(item.getSaleHome().getCount());
                cell.setCellStyle(cellStyle);

                cell = row.createCell(cellIndex++);
                if (item.getSaleHome() != null)
                cell.setCellValue(item.getSaleHome().getHouseArea().doubleValue());
                cell.setCellStyle(cellStyle);

                cell = row.createCell(cellIndex++);
                if (item.getSaleHome() != null)
                cell.setCellValue(item.getSaleHome().getSumPrice().doubleValue());
                cell.setCellStyle(cellStyle);

                cell = row.createCell(cellIndex++);
                if (item.getSaleUnHome() != null)
                cell.setCellValue(item.getSaleUnHome().getCount());
                cell.setCellStyle(cellStyle);

                cell = row.createCell(cellIndex++);
                if (item.getSaleUnHome() != null)
                cell.setCellValue(item.getSaleUnHome().getHouseArea().doubleValue());
                cell.setCellStyle(cellStyle);

                cell = row.createCell(cellIndex++);
                if (item.getSaleUnHome() != null)
                cell.setCellValue(item.getSaleUnHome().getSumPrice().doubleValue());
                cell.setCellStyle(cellStyle);


                cell = row.createCell(cellIndex++);
                if (item.getCancelHome() != null)
                cell.setCellValue(item.getCancelHome().getCount());
                cell.setCellStyle(cellStyle);

                cell = row.createCell(cellIndex++);
                if (item.getCancelHome() != null)
                cell.setCellValue(item.getCancelHome().getHouseArea().doubleValue());
                cell.setCellStyle(cellStyle);

                cell = row.createCell(cellIndex++);
                if (item.getCancelHome() != null)
                cell.setCellValue(item.getCancelHome().getSumPrice().doubleValue());
                cell.setCellStyle(cellStyle);

                cell = row.createCell(cellIndex++);
                if (item.getCancelUnHome() != null)
                cell.setCellValue(item.getCancelUnHome().getCount());
                cell.setCellStyle(cellStyle);

                cell = row.createCell(cellIndex++);
                if (item.getCancelUnHome() != null)
                cell.setCellValue(item.getCancelUnHome().getHouseArea().doubleValue());
                cell.setCellStyle(cellStyle);

                cell = row.createCell(cellIndex++);
                if (item.getCancelUnHome() != null)
                cell.setCellValue(item.getCancelUnHome().getSumPrice().doubleValue());
                cell.setCellStyle(cellStyle);

                //---

                cell = row.createCell(cellIndex++);
                if (item.getAbortHome() != null)
                    cell.setCellValue(item.getAbortHome().getCount());
                cell.setCellStyle(cellStyle);

                cell = row.createCell(cellIndex++);
                if (item.getAbortHome() != null)
                    cell.setCellValue(item.getAbortHome().getHouseArea().doubleValue());
                cell.setCellStyle(cellStyle);

                cell = row.createCell(cellIndex++);
                if (item.getAbortHome() != null)
                    cell.setCellValue(item.getAbortHome().getSumPrice().doubleValue());
                cell.setCellStyle(cellStyle);

                cell = row.createCell(cellIndex++);
                if (item.getAbortUnHome() != null)
                    cell.setCellValue(item.getAbortUnHome().getCount());
                cell.setCellStyle(cellStyle);

                cell = row.createCell(cellIndex++);
                if (item.getAbortUnHome() != null)
                    cell.setCellValue(item.getAbortUnHome().getHouseArea().doubleValue());
                cell.setCellStyle(cellStyle);

                cell = row.createCell(cellIndex++);
                if (item.getAbortUnHome() != null)
                    cell.setCellValue(item.getAbortUnHome().getSumPrice().doubleValue());
                cell.setCellStyle(cellStyle);

            }


            sheet.addMergedRegion(new CellRangeAddress(beginRow, rowIndex - 1, 0, 0));


        }
            row1 = sheet.createRow(rowIndex);
            Cell zzhjcell = row1.createCell(0);
            zzhjcell.setCellValue("合计");
            zzhjcell.setCellStyle(headCellStyle);
        cellIndex = 2;
        for(int i = 0; i< 6; i++){

            cell = row1.createCell(cellIndex++,Cell.CELL_TYPE_FORMULA);
            cell.setCellFormula("SUM(" + CellReference.convertNumToColString(cellIndex - 1) + "4:" + CellReference.convertNumToColString(cellIndex - 1)+rowIndex+")");
            cell.setCellStyle(headCellStyle);

            cell = row1.createCell(cellIndex++,Cell.CELL_TYPE_FORMULA);
            cell.setCellFormula("SUM(" + CellReference.convertNumToColString(cellIndex - 1) + "4:" + CellReference.convertNumToColString(cellIndex - 1)+rowIndex+")");
            cell.setCellStyle(headCellStyle);

            cell = row1.createCell(cellIndex++,Cell.CELL_TYPE_FORMULA);
            cell.setCellFormula("SUM(" + CellReference.convertNumToColString(cellIndex - 1) + "4:" + CellReference.convertNumToColString(cellIndex - 1)+rowIndex+")");
            cell.setCellStyle(headCellStyle);

        }






        sheet.setForceFormulaRecalculation(true);
        ExternalContext externalContext = facesContext.getExternalContext();
        externalContext.responseReset();
        externalContext.setResponseContentType("application/vnd.ms-excel");
        externalContext.setResponseHeader("Content-Disposition", "attachment;filename=exportContract.xlsx");
        try {
            workbook.write(externalContext.getResponseOutputStream());
            facesContext.responseComplete();
        } catch (IOException e) {
            facesMessages.addFromResourceBundle(StatusMessage.Severity.ERROR, "ExportIOError");
            Logging.getLog(getClass()).error("export error", e);

        }

    }
}
