@echo off
setlocal
set DIRNAME=%~dp0
set WRAPPER_DIR=%DIRNAME%\.mvn\wrapper
set WRAPPER_JAR=%WRAPPER_DIR%\maven-wrapper.jar
if not exist "%WRAPPER_JAR%" (
  echo Downloading maven-wrapper.jar...
  if exist "%SystemRoot%\System32\WindowsPowerShell\v1.0\powershell.exe" (
    powershell -Command "[Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12; iwr -UseBasicParsing https://repo1.maven.org/maven2/io/takari/maven-wrapper/0.5.6/maven-wrapper-0.5.6.jar -OutFile '%WRAPPER_JAR%'"
  ) else (
    certutil -urlcache -split -f https://repo1.maven.org/maven2/io/takari/maven-wrapper/0.5.6/maven-wrapper-0.5.6.jar "%WRAPPER_JAR%"
  )
)
java -cp "%WRAPPER_JAR%" -Dmaven.multiModuleProjectDirectory="%DIRNAME%" org.apache.maven.wrapper.MavenWrapperMain %*
