package person.cznno.commonpoi;

import org.apache.poi.ss.usermodel.CellStyle;

import java.util.List;

/**
 * Created by cznno
 * Date: 18-1-31
 */
public class ExcelTemplate {

    private String sheetName;

    private List<String> titleNameList;

    private CellStyle titleStyle;

    private List<CellStyle> columnStyleList;

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public List<String> getTitleNameList() {
        return titleNameList;
    }

    public void setTitleNameList(List<String> titleNameList) {
        this.titleNameList = titleNameList;
    }

    public CellStyle getTitleStyle() {
        return titleStyle;
    }

    public void setTitleStyle(CellStyle titleStyle) {
        this.titleStyle = titleStyle;
    }

    public List<CellStyle> getColumnStyleList() {
        return columnStyleList;
    }

    public void setColumnStyleList(List<CellStyle> columnStyleList) {
        this.columnStyleList = columnStyleList;
    }
}
