package person.cznno.commonpoi;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Map;

/**
 * Excel样式
 * Created by cznno
 * Date: 18-1-31
 */
public class ExcelStyles {

    private static Map<String,CellStyle> XSSFStyleMap;

    static {
        Workbook workbook = new XSSFWorkbook();

        CreationHelper createHelper = workbook.getCreationHelper();
        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(
                createHelper.createDataFormat().getFormat("yyyy/MM/dd"));
        CellStyle timeCellStyle = workbook.createCellStyle();
        timeCellStyle.setDataFormat(
                createHelper.createDataFormat().getFormat("HH:mm:ss"));
        CellStyle currentCellStyle = workbook.createCellStyle();
        currentCellStyle.setDataFormat(
                createHelper.createDataFormat().getFormat("¥#,##0"));

        XSSFStyleMap.put("dateCellStyle",dateCellStyle);
        XSSFStyleMap.put("timeCellStyle",timeCellStyle);
        XSSFStyleMap.put("currentCellStyle",currentCellStyle);
    }
}
