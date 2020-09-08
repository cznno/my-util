package system;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 * Created by cznno
 * Date: 18-5-7
 */
class Clipboard {

    /**
     * 从系统剪贴板中读取
     * @return 剪贴板中的信息
     */
    static Object readClipBoard() throws IOException, UnsupportedFlavorException {
        return Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
    }
}
