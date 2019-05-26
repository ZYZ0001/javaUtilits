package utilits.deletefile;

import java.io.File;

/**
 * 根据指定路径删除本地文件
 *
 * @author zyz
 * @create 2019-05-25
 */
public class DeleteFile {

    boolean flag = false; //是否完成删除的标志

    /**
     * 删除所有目录及文件
     *
     * @param path
     * @return
     */
    public boolean deleteFiles(String path) {
        flag = false;
        File file = new File(path);
        if (file.exists()) {
            if (file.isFile()) {
                flag = deleteFile(file);
            } else {
                flag = deleteDirectory(file);
            }
        }
        return flag;
    }

    /**
     * 删除单个文件
     *
     * @param file
     * @return
     */
    private boolean deleteFile(File file) {
        flag = false;
        if (file.isFile()) {
            file.delete();
            flag = true;
        }
        return flag;
    }

    /**
     * 删除目录及目录下的所有子目录及文件
     *
     * @param file
     * @return
     */
    private boolean deleteDirectory(File file) {
        flag = false;
        if (!file.isDirectory() || !file.exists()) {
            return flag;
        }
        flag = true;

        //删除文件夹下所有文件
        File[] files = file.listFiles();
        for (File subFile : files) {
            if (subFile.isFile()) {
                flag = subFile.delete();
                if (!flag) break; //删除失败,退出
            } else {
                flag = deleteDirectory(subFile);
                if (!flag) break; //删除失败,退出
            }
        }
        if (!flag) return false; //删除失败,退出
        flag = file.delete(); //删除最上级目录
        return flag;
    }
}