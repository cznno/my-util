package system;

import org.junit.jupiter.api.Test;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 * Created by cznno
 * Date: 18-5-7
 */
class ClipboardTest {

    @Test
    void readClipBoard() throws IOException, UnsupportedFlavorException {
        final Object o = Clipboard.readClipBoard();
        System.out.println(String.valueOf(o));
    }
}