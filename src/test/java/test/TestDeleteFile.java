package test;

import org.junit.Test;
import utilits.deletefile.DeleteFile;

import java.io.File;

/**
 * @author zyz
 * @create 2019-05-25
 */
public class TestDeleteFile {
    File file = new File("e:");
    @Test
    public void testDeleteFile() {
        DeleteFile deleteFile = new DeleteFile();
        deleteFile.deleteFiles("E:\\output");
    }

}
