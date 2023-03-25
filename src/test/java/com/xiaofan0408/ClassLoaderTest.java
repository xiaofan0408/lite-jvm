package com.xiaofan0408;


public class ClassLoaderTest {

    public static void testLoadClassFromDir() {
      final ClassLoader loader = new ClassLoader("misc");
  
      final ClassFile cf = loader.loadClassFileFromDir("misc", "Test");
      Assert.assertNotNull(cf, "load class file from dir");
    }
  
    public static void testLoadClassFromJar() {
      final String home = System.getenv("JAVA_HOME");
      String runtimeJarPath = home + "/jre/lib/rt.jar";
      final ClassLoader loader = new ClassLoader(runtimeJarPath);
  
      final ClassFile cf = loader.loadClassFileFromJar(runtimeJarPath, "java/lang/Object");
      Assert.assertNotNull(cf, "load class file from jar");
    }
  }