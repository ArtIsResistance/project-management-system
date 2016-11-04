warning: LF will be replaced by CRLF in .idea/modules.xml.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in .idea/compiler.xml.
The file will have its original line endings in your working directory.
[1mdiff --git a/.gitignore b/.gitignore[m
[1mdeleted file mode 100644[m
[1mindex 8842151..0000000[m
[1m--- a/.gitignore[m
[1m+++ /dev/null[m
[36m@@ -1,59 +0,0 @@[m
[31m-# Created by .ignore support plugin (hsz.mobi)[m
[31m-### JetBrains template[m
[31m-# Covers JetBrains IDEs: IntelliJ, RubyMine, PhpStorm, AppCode, PyCharm, CLion, Android Studio and Webstorm[m
[31m-# Reference: https://intellij-support.jetbrains.com/hc/en-us/articles/206544839[m
[31m-[m
[31m-# User-specific stuff:[m
[31m-.idea/workspace.xml[m
[31m-.idea/tasks.xml[m
[31m-.idea/dictionaries[m
[31m-.idea/vcs.xml[m
[31m-.idea/jsLibraryMappings.xml[m
[31m-[m
[31m-# Sensitive or high-churn files:[m
[31m-.idea/dataSources.ids[m
[31m-.idea/dataSources.xml[m
[31m-.idea/dataSources.local.xml[m
[31m-.idea/sqlDataSources.xml[m
[31m-.idea/dynamic.xml[m
[31m-.idea/uiDesigner.xml[m
[31m-[m
[31m-# Gradle:[m
[31m-.idea/gradle.xml[m
[31m-.idea/libraries[m
[31m-[m
[31m-# Mongo Explorer plugin:[m
[31m-.idea/mongoSettings.xml[m
[31m-[m
[31m-## File-based project format:[m
[31m-*.iws[m
[31m-[m
[31m-## Plugin-specific files:[m
[31m-[m
[31m-# IntelliJ[m
[31m-/out/[m
[31m-[m
[31m-# mpeltonen/sbt-idea plugin[m
[31m-.idea_modules/[m
[31m-[m
[31m-# JIRA plugin[m
[31m-atlassian-ide-plugin.xml[m
[31m-[m
[31m-# Crashlytics plugin (for Android Studio and IntelliJ)[m
[31m-com_crashlytics_export_strings.xml[m
[31m-crashlytics.properties[m
[31m-crashlytics-build.properties[m
[31m-fabric.properties[m
[31m-### Java template[m
[31m-*.class[m
[31m-[m
[31m-# Mobile Tools for Java (J2ME)[m
[31m-.mtj.tmp/[m
[31m-[m
[31m-# Package Files #[m
[31m-*.jar[m
[31m-*.war[m
[31m-*.ear[m
[31m-[m
[31m-# virtual machine crash logs, see http://www.java.com/en/download/help/error_hotspot.xml[m
[31m-hs_err_pid*[m
[1mdiff --git a/.idea/artifacts/project_management_system_war_exploded.xml b/.idea/artifacts/project_management_system_war_exploded.xml[m
[1mdeleted file mode 100644[m
[1mindex dc3961d..0000000[m
[1m--- a/.idea/artifacts/project_management_system_war_exploded.xml[m
[1m+++ /dev/null[m
[36m@@ -1,13 +0,0 @@[m
[31m-<component name="ArtifactManager">[m
[31m-  <artifact type="exploded-war" name="project-management-system:war exploded">[m
[31m-    <output-path>$PROJECT_DIR$/out/artifacts/project_management_system_war_exploded</output-path>[m
[31m-    <root id="root">[m
[31m-      <element id="javaee-facet-resources" facet="project-management-system/web/Web" />[m
[31m-      <element id="directory" name="WEB-INF">[m
[31m-        <element id="directory" name="classes">[m
[31m-          <element id="module-output" name="project-management-system" />[m
[31m-        </element>[m
[31m-      </element>[m
[31m-    </root>[m
[31m-  </artifact>[m
[31m-</component>[m
\ No newline at end of file[m
[1mdiff --git a/.idea/compiler.xml b/.idea/compiler.xml[m
[1mindex 96cc43e..2395c4a 100644[m
[1m--- a/.idea/compiler.xml[m
[1m+++ b/.idea/compiler.xml[m
[36m@@ -17,6 +17,16 @@[m
       <profile default="true" name="Default" enabled="false">[m
         <processorPath useClasspath="true" />[m
       </profile>[m
[32m+[m[32m      <profile default="false" name="Maven default annotation processors profile" enabled="true">[m
[32m+[m[32m        <sourceOutputDir name="target/generated-sources/annotations" />[m
[32m+[m[32m        <sourceTestOutputDir name="target/generated-test-sources/test-annotations" />[m
[32m+[m[32m        <outputRelativeToContentRoot value="true" />[m
[32m+[m[32m        <processorPath useClasspath="true" />[m
[32m+[m[32m        <module name="project-management-system" />[m
[32m+[m[32m      </profile>[m
     </annotationProcessing>[m
[32m+[m[32m    <bytecodeTargetLevel>[m
[32m+[m[32m      <module name="project-management-system" target="1.8" />[m
[32m+[m[32m    </bytecodeTargetLevel>[m
   </component>[m
 </project>[m
\ No newline at end of file[m
[1mdiff --git a/.idea/misc.xml b/.idea/misc.xml[m
[1mindex 47095a6..1c811aa 100644[m
[1m--- a/.idea/misc.xml[m
[1m+++ b/.idea/misc.xml[m
[36m@@ -1,10 +1,51 @@[m
 <?xml version="1.0" encoding="UTF-8"?>[m
 <project version="4">[m
[31m-  <component name="MavenImportPreferences">[m
[31m-    <option name="generalSettings">[m
[31m-      <MavenGeneralSettings>[m
[31m-        <option name="mavenHome" value="Bundled (Maven 3)" />[m
[31m-      </MavenGeneralSettings>[m
[32m+[m[32m  <component name="ClientPropertiesManager">[m
[32m+[m[32m    <properties class="javax.swing.AbstractButton">[m
[32m+[m[32m      <property name="hideActionText" class="java.lang.Boolean" />[m
[32m+[m[32m    </properties>[m
[32m+[m[32m    <properties class="javax.swing.JComponent">[m
[32m+[m[32m      <property name="html.disable" class="java.lang.Boolean" />[m
[32m+[m[32m    </properties>[m
[32m+[m[32m    <properties class="javax.swing.JEditorPane">[m
[32m+[m[32m      <property name="JEditorPane.w3cLengthUnits" class="java.lang.Boolean" />[m
[32m+[m[32m      <property name="JEditorPane.honorDisplayProperties" class="java.lang.Boolean" />[m
[32m+[m[32m      <property name="charset" class="java.lang.String" />[m
[32m+[m[32m    </properties>[m
[32m+[m[32m    <properties class="javax.swing.JList">[m
[32m+[m[32m      <property name="List.isFileList" class="java.lang.Boolean" />[m
[32m+[m[32m    </properties>[m
[32m+[m[32m    <properties class="javax.swing.JPasswordField">[m
[32m+[m[32m      <property name="JPasswordField.cutCopyAllowed" class="java.lang.Boolean" />[m
[32m+[m[32m    </properties>[m
[32m+[m[32m    <properties class="javax.swing.JSlider">[m
[32m+[m[32m      <property name="Slider.paintThumbArrowShape" class="java.lang.Boolean" />[m
[32m+[m[32m      <property name="JSlider.isFilled" class="java.lang.Boolean" />[m
[32m+[m[32m    </properties>[m
[32m+[m[32m    <properties class="javax.swing.JTable">[m
[32m+[m[32m      <property name="Table.isFileList" class="java.lang.Boolean" />[m
[32m+[m[32m      <property name="JTable.autoStartsEdit" class="java.lang.Boolean" />[m
[32m+[m[32m      <property name="terminateEditOnFocusLost" class="java.lang.Boolean" />[m
[32m+[m[32m    </properties>[m
[32m+[m[32m    <properties class="javax.swing.JToolBar">[m
[32m+[m[32m      <property name="JToolBar.isRollover" class="java.lang.Boolean" />[m
[32m+[m[32m    </properties>[m
[32m+[m[32m    <properties class="javax.swing.JTree">[m
[32m+[m[32m      <property name="JTree.lineStyle" class="java.lang.String" />[m
[32m+[m[32m    </properties>[m
[32m+[m[32m    <properties class="javax.swing.text.JTextComponent">[m
[32m+[m[32m      <property name="caretAspectRatio" class="java.lang.Double" />[m
[32m+[m[32m      <property name="caretWidth" class="java.lang.Integer" />[m
[32m+[m[32m    </properties>[m
[32m+[m[32m  </component>[m
[32m+[m[32m  <component name="EntryPointsManager">[m
[32m+[m[32m    <entry_points version="2.0" />[m
[32m+[m[32m  </component>[m
[32m+[m[32m  <component name="MavenProjectsManager">[m
[32m+[m[32m    <option name="originalFiles">[m
[32m+[m[32m      <list>[m
[32m+[m[32m        <option value="$PROJECT_DIR$/pom.xml" />[m
[32m+[m[32m      </list>[m
     </option>[m
   </component>[m
   <component name="ProjectLevelVcsManager" settingsEditedManually="false">[m
[36m@@ -20,20 +61,4 @@[m
   <component name="ProjectRootManager" version="2" languageLevel="JDK_1_8" default="true" assert-keyword="true" jdk-15="true" project-jdk-name="1.8" project-jdk-type="JavaSDK">[m
     <output url="file://$PROJECT_DIR$/out" />[m
   </component>[m
[31m-  <component name="masterDetails">[m
[31m-    <states>[m
[31m-      <state key="ProjectJDKs.UI">[m
[31m-        <settings>[m
[31m-          <last-edited>1.8</last-edited>[m
[31m-          <splitter-proportions>[m
[31m-            <option name="proportions">[m
[31m-              <list>[m
[31m-                <option value="0.2" />[m
[31m-             warning: LF will be replaced by CRLF in .idea/misc.xml.
The file will have its original line endings in your working directory.
 </list>[m
[31m-            </option>[m
[31m-          </splitter-proportions>[m
[31m-        </settings>[m
[31m-      </state>[m
[31m-    </states>[m
[31m-  </component>[m
 </project>[m
\ No newline at end of file[m
[1mdiff --git a/.idea/sqldialects.xml b/.idea/sqldialects.xml[m
[1mdeleted file mode 100644[m
[1mindex e3cfb27..0000000[m
[1m--- a/.idea/sqldialects.xml[m
[1m+++ /dev/null[m
[36m@@ -1,6 +0,0 @@[m
[31m-<?xml version="1.0" encoding="UTF-8"?>[m
[31m-<project version="4">[m
[31m-  <component name="SqlDialectMappings">[m
[31m-    <file url="file://$PROJECT_DIR$" dialect="SQLite" />[m
[31m-  </component>[m
[31m-</project>[m
\ No newline at end of file[m
[1mdiff --git a/project-management-system.iml b/project-management-system.iml[m
[1mindex c29b94d..5316010 100644[m
[1m--- a/project-management-system.iml[m
[1m+++ b/project-management-system.iml[m
[36m@@ -1,28 +1,55 @@[m
 <?xml version="1.0" encoding="UTF-8"?>[m
[31m-<module type="JAVA_MODULE" version="4">[m
[31m-  <component name="FacetManager">[m
[31m-    <facet type="web" name="Web">[m
[31m-      <configuration>[m
[31m-        <descriptors>[m
[31m-          <deploymentDescriptor name="web.xml" url="file://$MODULE_DIR$/web/WEB-INF/web.xml" />[m
[31m-        </descriptors>[m
[31m-        <webroots>[m
[31m-          <root url="file://$MODULE_DIR$/web" relative="/" />[m
[31m-        </webroots>[m
[31m-      </configuration>[m
[31m-    </facet>[m
[31m-    <facet type="Spring" name="Spring">[m
[31m-      <configuration />[m
[31m-    </facet>[m
[31m-  </component>[m
[31m-  <component name="NewModuleRootManager" inherit-compiler-output="true">[m
[31m-    <exclude-output />[m
[32m+[m[32m<module org.jetbrains.idea.maven.project.MavenProjectsManager.isMavenModule="true" type="JAVA_MODULE" version="4">[m
[32m+[m[32m  <component name="NewModuleRootManager" LANGUAGE_LEVEL="JDK_1_8" inherit-compiler-output="false">[m
[32m+[m[32m    <output url="file://$MODULE_DIR$/target/classes" />[m
[32m+[m[32m    <output-test url="file://$MODULE_DIR$/target/test-classes" />[m
     <content url="file://$MODULE_DIR$">[m
[31m-      <sourceFolder url="file://$MODULE_DIR$/src" isTestSource="false" />[m
[32m+[m[32m      <sourceFolder url="file://$MODULE_DIR$/src/main/java" isTestSource="false" />[m
[32m+[m[32m      <sourceFolder url="file://$MODULE_DIR$/src/main/resources" type="java-resource" />[m
[32m+[m[32m      <sourceFolder url="file://$MODULE_DIR$/src/test/java" isTestSource="true" />[m
[32m+[m[32m      <excludeFolder url="file://$MODULE_DIR$/target" />[m
     </content>[m
     <orderEntry type="inheritedJdk" />[m
     <orderEntry type="sourceFolder" forTests="false" />[m
[31m-    <orderEntry type="library" name="Spring-4.3.3.RELEASE" level="project" />[m
[31m-    <orderEntry type="library" name="Spring MVC-4.3.3.RELEASE" level="project" />[m
[32m+[m[32m    <orderEntry type="library" scope="TEST" name="Maven: junit:junit:3.8.1" level="project" />[m
[32m+[m[32m    <orderEntry type="library" name="Maven: org.springframework.boot:spring-boot-starter-thymeleaf:1.4.1.RELEASE" level="project" />[m
[32m+[m[32m    <orderEntry type="library" name="Maven: org.springframework.boot:spring-boot-starter:1.4.1.RELEASE" level="project" />[m
[32m+[m[32m    <orderEntry type="library" name="Maven: org.springframework.boot:spring-boot-starter-logging:1.4.1.RELEASE" level="project" />[m
[32m+[m[32m    <orderEntry type="library" name="Maven: ch.qos.logback:logback-classic:1.1.7" level="project" />[m
[32m+[m[32m    <orderEntry type="library" name="Maven: ch.qos.logback:logback-core:1.1.7" level="project" />[m
[32m+[m[32m    <orderEntry type="library" name="Maven: org.slf4j:jcl-over-slf4j:1.7.21" level="project" />[m
[32m+[m[32m    <orderEntry type="library" name="Maven: org.slf4j:jul-to-slf4j:1.7.21" level="project" />[m
[32m+[m[32m    <orderEntry type="library" name="Maven: org.slf4j:log4j-over-slf4j:1.7.21" level="project" />[m
[32m+[m[32m    <or