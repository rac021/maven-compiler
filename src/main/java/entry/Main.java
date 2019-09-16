package entry;

import coby.inra.GitCloner;
import coby.inra.MavenCompiler;
import coby.inra.Utils;
import static coby.inra.Utils.mv;
import static coby.inra.Utils.rm;

public class Main {

    public static void main(String[] args ) throws Exception {
        
        /*
        
         reset ; java -jar -DGitUrl="https://github.com/rac021/yedGen.git"  \
                           -DGitOut="test/tmp_project"                      \
                           -DLocalProjectPathToCompile="test/tmp_project"   \
                           -DMoveSource="test/tmp_project/target/yedGen_2.1-2.1-jar-with-dependencies.jar"\
                           -DMoveToDest="./test"                            \
                           -DMoveRenameTo="yedGen_021_021.jar"              \
                           -DGitClean="true"                                \
                           -DLocalProjectClean="true"                       \
                            maven-compiler.jar clean install assembly:single
               
          
        reset ; java -jar -DGitUrl="https://github.com/rac021/Jaxy.git"                                         \
                            -DGitOut="test/tmp_project"                                                 \
                            -DLocalProjectPathToCompile="test/tmp_project/src/dependencies/01_jaxy-api" \
                             maven-compiler.jar clean install  
        
        java -jar -DLocalProjectPathToCompile="test/tmp_project/src/dependencies/02_jaxy-security-provider/" \
                  maven-compiler.jar clean install
        
        java -jar -DLocalProjectPathToCompile="test/tmp_project/src/dependencies/03_jaxy-service-discovery/" \
                  maven-compiler.jar clean install 
        
        java -jar -DLocalProjectPathToCompile="test/tmp_project/src/dependencies/04_certMe/"   \
                  maven-compiler.jar clean install 
        
        java -jar -DLocalProjectPathToCompile="test/tmp_project/src/jaxy/"           \
                  -DMoveSource="test/tmp_project/src/jaxy/target/jaxy-thorntail.jar" \
                  -DMoveToDest="./test"                                              \
                  -DMoveRenameTo="jaxy-thorntail_FINAL.jar"                          \
                  -DLocalProjectClean="true"                                         \
                  -DRemoveFolder="test/tmp_project"                                  \
                   maven-compiler.jar clean install                  
       */
        
        String  gitUrl   = System.getProperty("GitUrl")   ;
        String  gitOut   = System.getProperty("GitOut")   ;       
        boolean gitClean = System.getProperty("GitClean") != null ;
       
        String  localProjectPath  = System.getProperty("LocalProjectPathToCompile") ;       
        boolean localProjectClean = System.getProperty("LocalProjectClean") != null ;
       
        String moveSource   = System.getProperty("MoveSource")   ;
        String moveToDest   = System.getProperty("MoveToDest")   ;
        String moveRenameTo = System.getProperty("MoveRenameTo") ;
        
        String removeFolder = System.getProperty("RemoveFolder") ;
       
        System.out.println(" ")                                          ;
        System.out.println(" GitUrl            : " + gitUrl )            ;
        System.out.println(" GITOut            : " + gitOut )            ;
        System.out.println(" localProjectPath  : " + localProjectPath )  ;
        System.out.println(" localProjectClean : " + localProjectClean ) ;        
        System.out.println(" moveSource        : " + moveSource )        ;
        System.out.println(" moveToDest        : " + moveToDest )        ;         
        System.out.println(" moveRenameTo      : " + moveRenameTo )      ;         
        System.out.println(" ")                                          ;
        
       if ( gitUrl != null && gitOut != null ) {
           GitCloner.clone( gitUrl, gitOut )   ;
       }
       
       if( localProjectPath != null ) {
          MavenCompiler.compile( localProjectPath, args ) ;
       } else {
          System.out.println(" Nothing To Do ! " )        ;
       }
       
       if( moveSource != null && moveToDest != null ) {
           mv(moveSource , moveToDest, moveRenameTo ) ;
       }          
       
       if ( gitClean )          Utils.rm(gitOut)              ;
              
       if ( localProjectClean ) Utils.rm(localProjectPath)    ;
      
       if( removeFolder != null && ! removeFolder.isEmpty() ) {
          rm(removeFolder)  ;
       }
       
    }
}
