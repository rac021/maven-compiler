
Maven-Compiler

==

No need any maven installation

==

```bash
   java -DLocalProjectPathToCompile="path/to/my/project/" -jar maven-compiler.jar <MAVEN-COMMAND>
```

Example :

```bash

reset ; java -jar -DGitUrl="https://github.com/rac021/Jaxy.git"                               \
                  -DGitOut="test/tmp_project"                                                 \
                  -DLocalProjectPathToCompile="test/tmp_project/src/dependencies/01_jaxy-api" \
                   maven-compiler.jar clean install  
        
 java -jar -DLocalProjectPathToCompile="test/tmp_project/src/dependencies/02_jaxy-security-provider/" \
            maven-compiler.jar clean install
        
 java -jar -DLocalProjectPathToCompile="test/tmp_project/src/dependencies/03_jaxy-service-discovery/" \
            maven-compiler.jar clean install 
        
 java -jar -DLocalProjectPathToCompile="test/tmp_project/src/dependencies/04_certMe/" \
            maven-compiler.jar clean install 
        
 java -jar -DLocalProjectPathToCompile="test/tmp_project/src/jaxy/"           \
           -DMoveSource="test/tmp_project/src/jaxy/target/jaxy-thorntail.jar" \
           -DMoveToDest="./test"                                              \
           -DMoveRenameTo="jaxy-thorntail_FINAL.jar"                          \
           -DLocalProjectClean="true"                                         \
           -DRemoveFolder="test/tmp_project"                                  \
            maven-compiler.jar clean install
               
```
