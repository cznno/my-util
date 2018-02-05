/*
package person.cznno.commonpoi;

import javafx.scene.control.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.Map;

*/
/**
 * Excel工具
 * Created by cznno
 * Date: 18-1-18
 *//*

public class ExcelUtil {

    private static final String DOWNLOAD_HEADER_NAME =
            "Content-Disposition";
    private static final String DOWNLOAD_HEADER_VALUE =
            "attachment; filename=";
    private static final String CONTENT_TYPE_XLSX =
            "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    private static final String XLSX_EXTENSION = ".xlsx";

    */
/**
     * 生成Xlsx文档
     *
     * @param list      数据
     * @param excelData excel模板数据
     * @return xlsx文档字节
     * @throws IOException 读写文件错误
     *//*

    public static byte[] generateXlsx(List list, IWriteExcelData excelData) throws IOException {

        String title = excelData.getTitle();

        Workbook workbook = new XSSFWorkbook();
        ExcelTemplate template = loadTemplate(excelData.getTemplateFileName());
        List<CellStyle> cellStyles = getCellStyles(workbook, template.getColumnStyleList());

        Sheet sheet = workbook.createSheet(title);

        // 产生表格标题行
        Row titleRow = sheet.createRow(0);
        int columnSize = template.getTitleNameList().size();
        List<String> titleNameList = template.getTitleNameList();
        for (int i = 0; i < columnSize; i++) {
            Cell cell = titleRow.createCell(i);
            cell.setCellValue(titleNameList.get(i));
            cell.getCellStyle().cloneStyleFrom(template.getTitleStyle());
        }

        int index = 1;
        for (Object o : list) {
            Row dataRow = sheet.createRow(index++);
            for (int i = 0; i < columnSize; i++) {
                String titleName = titleRow.getCell(i).getStringCellValue();
                Cell dataCell = dataRow.createCell(i);
                boolean setNormalDataValue =
                        excelData.customDataValue(o, titleName, dataCell);
                if (setNormalDataValue) {
                    ExcelUtil.setCellValue(o, titleName, dataCell, excelData.getMethodMap());
                }
                dataCell.setCellStyle(cellStyles.get(i));
            }
        }

        for (int i = 0; i < 15; i++) {
            sheet.autoSizeColumn(i);
        }
        return getWorkBookBytes(workbook);
    }

    private static ExcelTemplate loadTemplate(String fileName) throws IOException {

        ExcelTemplate template = new ExcelTemplate();

        Resource res = new ClassPathResource("file/" + fileName);
        InputStream in = res.getInputStream();
        Workbook work = new XSSFWorkbook(in);
        Sheet sheet = work.getSheetAt(0);

        template.setSheetName(sheet.getSheetName());
        template.setTitleStyle(sheet.getRow(0).getCell(0).getCellStyle());

        short columnSize = sheet.getRow(0).getLastCellNum();
        List<String> titleNameList = new ArrayList<>();
        List<CellStyle> columnStyleList = new ArrayList<>();
        for (short i = 0; i < columnSize; i++) {
            titleNameList.add(sheet.getRow(0).getCell(i).getStringCellValue());
            columnStyleList.add(sheet.getRow(2).getCell(i).getCellStyle());
        }
        template.setTitleNameList(titleNameList);
        template.setColumnStyleList(columnStyleList);

        work.close();
        in.close();
        return template;
    }

    public static void setXLSXDownlodResponse(String filename) {
        String attachment = DOWNLOAD_HEADER_VALUE + filename + XLSX_EXTENSION;
        ResponseUtil.setDownloadResponse(DOWNLOAD_HEADER_NAME, attachment, CONTENT_TYPE_XLSX);
    }

    private static List<CellStyle> getCellStyles(Workbook workbook, List<CellStyle> templateCellStyles) {
        List<CellStyle> cellStyles = new ArrayList<>();
        for (CellStyle style : templateCellStyles) {
            CellStyle newStyle = workbook.createCellStyle();
            newStyle.cloneStyleFrom(style);
            cellStyles.add(newStyle);
        }
        return cellStyles;
    }

    private static byte[] getWorkBookBytes(Workbook workbook) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        final byte[] bytes = out.toByteArray();
        out.close();
        return bytes;
    }

    private static void setCellValue(Object record, String titleName, Cell dataCell, Map<String, String> methodMap) {
        try {
            String methodName = methodMap.get(titleName);
            Method method = record.getClass().getMethod(methodName);
            Type type = method.getGenericReturnType();

            switch (type.getTypeName()) {
                case "java.lang.String":
                    dataCell.setCellValue((String) method.invoke(record));
                    break;
                case "java.util.Date":
                    dataCell.setCellValue((Date) method.invoke(record));
                    break;
                case "float":
                    dataCell.setCellValue((float) method.invoke(record));
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
*/
