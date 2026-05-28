#!/usr/bin/env sh
set -e
DIRNAME="$(cd "$(dirname "$0")" && pwd)"
WRAPPER_DIR="$DIRNAME/.mvn/wrapper"
WRAPPER_JAR="$WRAPPER_DIR/maven-wrapper.jar"
if [ ! -f "$WRAPPER_JAR" ]; then
  echo "Downloading maven-wrapper.jar..."
  mkdir -p "$WRAPPER_DIR"
  curl -fsSL -o "$WRAPPER_JAR" "https://repo1.maven.org/maven2/io/takari/maven-wrapper/0.5.6/maven-wrapper-0.5.6.jar"
fi
java -cp "$WRAPPER_JAR" -Dmaven.multiModuleProjectDirectory="$DIRNAME" org.apache.maven.wrapper.MavenWrapperMain "$@"
