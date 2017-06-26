package demo;

import java.util.Stack;

public class ClassloaderUtil {  
        public static String getCurrentClassloaderDetail() {  
  
                StringBuffer classLoaderDetail = new StringBuffer();  
  
                Stack<ClassLoader> classLoaderStack = new Stack<ClassLoader>();  
  
                ClassLoader currentClassLoader = Thread.currentThread()  
                                .getContextClassLoader();  
  
                classLoaderDetail  
                                .append("\n-----------------------------------------------------------------\n");  
  
                // Build a Stack of the current ClassLoader chain  
  
                while (currentClassLoader != null) {  
  
                        classLoaderStack.push(currentClassLoader);  
  
                        currentClassLoader = currentClassLoader.getParent();  
  
                }  
  
                // Print ClassLoader parent chain  
  
                while (classLoaderStack.size() > 0) {  
  
                        ClassLoader classLoader = classLoaderStack.pop();  
  
                        // Print current  
  
                        classLoaderDetail.append(classLoader);  
  
                        if (classLoaderStack.size() > 0) {  
  
                                classLoaderDetail.append("\n--- delegation ---\n");  
  
                        } else {  
  
                                classLoaderDetail.append(" **Current ClassLoader**");  
  
                        }  
  
                }  
  
                classLoaderDetail  
                                .append("\n-----------------------------------------------------------------\n");  
                System.out.println(classLoaderDetail.toString());
                return classLoaderDetail.toString();  
  
        }  
}  