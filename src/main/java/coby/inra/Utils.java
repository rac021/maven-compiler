
package coby.inra ;

import java.io.File ;
import java.io.IOException ;
import org.apache.commons.io.FileUtils ;


/**
 *
 * @author ryahiaoui
 */
public class Utils {
    
  public static boolean mkdir(String directory ) {      
    System.out.println(" Create Folder : " + directory ) ;
    File fDirectory = new File(directory) ;
    return fDirectory.mkdir() ;
  }
 
  public static void rm( String path ) throws IOException {      
     if( ! new File(path).exists() ) {
         System.out.println(" Path : " + path + " - Not exists :" ) ;
         return        ;
     }     
     System.out.println(" Remove Path : " + path ) ;
     if(new File(path).isDirectory()) {
       FileUtils.deleteDirectory(new File(path))  ;
     }
     else {
        new File(path).delete() ;
     }
  }
  
   public static boolean mv ( String fileSource, String fileDest, String name ) throws IOException {
      
      if( ! new File(fileSource).exists()) {
          System.err.println(" File " + fileSource + " not found ! " ) ;
          return false ;
      }
        
      String dest = fileDest.endsWith( File.separator) ? fileDest   +
                                       ( name == null ? new File(fileSource).getName() : name ) : 
                                       fileDest +  File.separator   +
                                       ( name == null ? new File(fileSource).getName() : name ) ;
      
      if( new File(dest).exists() && new File(dest).isFile()) {
          System.out.println( dest + " Already Exists.. Replace" ) ;
          rm( dest) ;
      }     
    
       if( name == null ) {
          FileUtils.moveFileToDirectory( new File(fileSource), new File(fileDest), true) ;
        }
        else {
          FileUtils.moveFile( new File(fileSource) , new File(dest ) ) ;
        }
        return true ;
  }
   
}
