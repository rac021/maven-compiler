
package coby.inra;

import org.apache.maven.cli.MavenCli;

/**
 *
 * @author ryahiaoui
 */
public class MavenCompiler {
 
    
    public static void compile( String path , String[] args ) {
		
        System.out.println("Project Path : " + path ) ; 
        
        if( path == null ) path = "." ;
        
        new MavenCli().doMain( args, path, System.out, System.err ) ;
    }
    
}
