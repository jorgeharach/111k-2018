/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campos.utils;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author George
 */
public class FrameUtils {

    public static void centrarComponent(Component frame) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension frameSize = frame.getSize();
        Dimension monitorSize = tk.getScreenSize();
        frame.setLocation(
                (monitorSize.width - frameSize.width) / 2,
                (monitorSize.height - frameSize.height) / 2
        );
    }

}
