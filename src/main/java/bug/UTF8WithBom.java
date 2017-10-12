package bug;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * utf-8 bom 引起的读取配置文件失败的bug
 * @author LBG - 2017/10/11 0011
 */
public class UTF8WithBom {

    public static void main(String[] args) throws IOException {
        URL resource = Thread.currentThread().getContextClassLoader().getResource("bug/text.properties");
        if (resource != null) {
            System.out.println(resource.getPath());
            File file = new File(resource.getPath());
            System.out.println(FileUtils.readFileToString(file));
        }
    }
}
