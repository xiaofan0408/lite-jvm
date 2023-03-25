package com.xiaofan0408.classreader;

import com.xiaofan0408.classfile.ClassFile;

public class ClassLoader {

  private String classpath;

  public ClassReader(String classpath){
      this.classpath = classpath;
  }

  
  public ClassFile loadClassFileFromJar(String path,String name){
    ZipFile file;
    try {
      file = new ZipFile(path);
    } catch (IOException e) {
      throw new IllegalStateException("not found jar file, " + path);
    }

    ZipEntry entry = file.getEntry(name + ".class");
    if (entry == null) {
      return null;
    }

    try (InputStream is = file.getInputStream(entry);
        DataInputStream dis = new DataInputStream(is)) {
      return ClassReader.read(dis);
    } catch (Exception e) {
      e.printStackTrace();
      throw new IllegalStateException("read class failure, " + name);
    }
  }
  public ClassFile loadClassFileFromDir(String path, String name) { 
    if (!name.contains("/")) {
      final File dir = new File(path);
      if (!dir.exists()) {
        return null;
      }
      final String[] files = dir.list();
      if (files == null) {
        return null;
      }

      for (String file : files) {
        // found it
        if (Objects.equals(file, name + ".class")) {
          try (FileInputStream fis = new FileInputStream(new File(path + "/" + name + ".class"));
              DataInputStream dis = new DataInputStream(fis)) {
            return ClassReader.read(dis);
          } catch (Exception e) {
            throw new IllegalStateException("read class failure, " + name);
          }
        }
      }
      return null;
    }

    // 继续下一个目录
    int idx = name.indexOf("/");
    String subDir = name.substring(0, idx);
    String subPath = path + "/" + subDir;
    final String newName = name.substring(idx + 1);
    return loadClassFileFromDir(subPath, newName);
  }


}