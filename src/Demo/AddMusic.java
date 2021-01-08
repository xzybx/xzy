package Demo;

import java.applet.AudioClip;
import java.io.*;
import java.applet.Applet;
import java.awt.Frame;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import javax.swing.JFrame;
public class AddMusic extends JFrame{
  File f;
  URI uri;
   URL url;
// Music(){
//     bgMusic();
//  }
AddMusic(){
  try {
      f = new File("Taylor Swift-Sparks Fly.wav");
      uri = f.toURI();
      url = uri.toURL();  //解析地址
      AudioClip aau;
      aau = Applet.newAudioClip(url);
      aau.loop();  //循环播放
  } catch (Exception e)
  { e.printStackTrace();
  }
}
 public static void main(String args[]) {
   new AddMusic();
 }
}