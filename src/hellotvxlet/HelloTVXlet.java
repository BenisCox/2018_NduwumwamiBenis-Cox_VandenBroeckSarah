package hellotvxlet;


import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.tv.xlet.*;
import org.davic.resources.ResourceClient;
import org.davic.resources.ResourceProxy;
import org.havi.ui.*;
import org.havi.ui.event.HActionListener;
import org.havi.ui.event.HBackgroundImageEvent;
import org.havi.ui.event.HBackgroundImageListener;
import java.awt.*;











public class HelloTVXlet implements Xlet, ResourceClient, HBackgroundImageListener {
     HBackgroundImage image ;

     HStillImageBackgroundConfiguration hsbconfig;
     
     
      
    public void initXlet(XletContext ctx) throws XletStateChangeException { HScreen screen=HScreen.getDefaultHScreen();
        HBackgroundDevice hbgDev=screen.getDefaultHBackgroundDevice(); 
        if (hbgDev.reserveDevice(this))
        {
            System.out.println("Achtergrond device succesvol gereserveerd");
        }

        HBackgroundConfigTemplate bgTemplate=new HBackgroundConfigTemplate();
        bgTemplate.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, HBackgroundConfigTemplate.REQUIRED);
         hsbconfig=(HStillImageBackgroundConfiguration) hbgDev.getBestConfiguration(bgTemplate);
        
        
         
         
        try {
            hbgDev.setBackgroundConfiguration(hsbconfig);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

       image =new HBackgroundImage("Achtergrond.jpg");
     

       

  
            image.load(this); 

        
    }   

    public void imageLoaded(HBackgroundImageEvent e) {

       System.out.println("Image succesvol geladen");

      

     

       try {

            hsbconfig.displayImage(image);

        } catch (Exception ex) {

            ex.printStackTrace();

        }

     }

    

    public void pauseXlet() {

       

    }


    public void startXlet() throws XletStateChangeException {

     

    }


    public boolean requestRelease(ResourceProxy proxy, Object requestData) {

        throw new UnsupportedOperationException("Not supported yet.");

    }


    public void release(ResourceProxy proxy) {

        throw new UnsupportedOperationException("Not supported yet.");

    }


    public void notifyRelease(ResourceProxy proxy) {

        throw new UnsupportedOperationException("Not supported yet.");

    }



    public void imageLoadFailed(HBackgroundImageEvent e) {

        throw new UnsupportedOperationException("Not supported yet.");

    }


  

    public void destroyXlet(boolean unconditional) throws XletStateChangeException {

      

    }


}