
package coby.inra;

import java.io.File;
import org.eclipse.jgit.api.Git;

/**
 *
 * @author ryahiaoui
 */
public class GitCloner {
    
    
    public static boolean clone( String remoteUrl, String localPath ) throws Exception {

      System.out.println("Cloning Project from Repo : " + remoteUrl + " to " + localPath) ;

      try ( Git result = Git.cloneRepository()
                            .setURI(remoteUrl)
                            .setDirectory(new File(localPath))
                            .call() ) {
	        System.out.println("Having repository : " + result.getRepository().getDirectory());
                return true ;
        } catch( Exception x) {
            System.out.println(" Git Error : " +x.getMessage() ) ;
            return false ;
        } 
    }
     
}
