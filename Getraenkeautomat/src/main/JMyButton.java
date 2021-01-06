package main;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
  * class JMyButton<br>
  * Erzeugt einen neuen Button mit 4 verschiedenen Icons:<br>
  * 1. Button aktiviert<br>
  * 2. Maus wird darüberbewegt<br>
  * 3. Button gedrückt<br>
  * 4. Button deaktiviert<br>
  */
public class JMyButton extends JButton {
  private ImageIcon icon, rollover_icon, pressed_icon, disabled_icon;

  /**
    * Alle Icons sind identisch
    * @param pathStr Pfadname zu den Icons
    * @param fStr Dateiname des Icons
    */
  public JMyButton(URL urlIcon) {
    super();

    icon = new ImageIcon(urlIcon);
    rollover_icon = icon;
    pressed_icon = icon;
    disabled_icon = icon;

    setIcon(icon);
    setBorderPainted(false);
    setFocusPainted(false);
    setContentAreaFilled(false);
  }

  /**
    * @param pathStr Pfadname zu den Icons
    * @param f1Str Dateiname des Standard-Icons
    * @param f2Str Dateiname des Icons 'Maus darüber'
    * @param f3Str Dateiname des Icons 'Button gedrückt'
    * @param f4Str Dateiname des Icons 'Button deaktiviert'
    */
  public JMyButton(URL urlF1, URL urlF2, URL urlF3, URL urlF4) {
    super();

    icon = new ImageIcon(urlF1);
    rollover_icon = new ImageIcon(urlF2);
    pressed_icon = new ImageIcon(urlF3);
    disabled_icon = new ImageIcon(urlF4);

    setIcon(icon);
    setPressedIcon(pressed_icon);
    setRolloverIcon(rollover_icon);
    setDisabledIcon(disabled_icon);
    setBorderPainted(false);
    setFocusPainted(false);
    setContentAreaFilled(false);
  }

}
