import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Liuzd QQ: 77822013 2019/2/16 0016
 */
public class TestFdfs {
    public class TestFastDfs {

        public String conf_filename = "D:\\proj\\demo-parent\\thread-demo\\src\\main\\resources\\fdfs_client.conf";
        //public String local_filename = "D:\\stsworkspace\\fastdfs-demo\\src\\main\\resources\\fdfs_client.conf";

        public String local_filename = "D:\\my\\timg.jpg";

        @Before
        public void setUp() throws Exception {
        }

        @After
        public void tearDown() throws Exception {
        }

        @Test
        public void testUpload() throws IOException, MyException {

            try {
                ClientGlobal.init(conf_filename);

                TrackerClient tracker = new TrackerClient();
                TrackerServer trackerServer = tracker.getConnection();
                StorageServer storageServer = null;

                StorageClient storageClient = new StorageClient(trackerServer, storageServer);
//          NameValuePair nvp = new NameValuePair("age", "18");
                NameValuePair nvp [] = new NameValuePair[]{
                        new NameValuePair("age", "18"),
                        new NameValuePair("sex", "male")
                };
                String fileIds[] = storageClient.upload_file(local_filename, "png", nvp);

                System.out.println(fileIds.length);
                System.out.println("组名：" + fileIds[0]);
                System.out.println("路径: " + fileIds[1]);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (MyException e) {
                e.printStackTrace();
            }
        }

       /* @Test
        public void testDownload() {
            try {

                ClientGlobal.init(conf_filename);

                TrackerClient tracker = new TrackerClient();
                TrackerServer trackerServer = tracker.getConnection();
                StorageServer storageServer = null;

                StorageClient storageClient = new StorageClient(trackerServer, storageServer);
                byte[] b = storageClient.download_file("group1", "M00/00/00/wKgRcFV_08OAK_KCAAAA5fm_sy874.conf");
                System.out.println(b);
                IOUtils.write(b, new FileOutputStream("D:/"+ UUID.randomUUID().toString()+".conf"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
*/
        @Test
        public void testGetFileInfo(){
            try {
                ClientGlobal.init(conf_filename);

                TrackerClient tracker = new TrackerClient();
                TrackerServer trackerServer = tracker.getConnection();
                StorageServer storageServer = null;

                StorageClient storageClient = new StorageClient(trackerServer, storageServer);
                FileInfo fi = storageClient.get_file_info("group1", "M00/00/00/wKgRcFV_08OAK_KCAAAA5fm_sy874.conf");
                System.out.println(fi.getSourceIpAddr());
                System.out.println(fi.getFileSize());
                System.out.println(fi.getCreateTimestamp());
                System.out.println(fi.getCrc32());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Test
        public void testGetFileMate(){
            try {
                ClientGlobal.init(conf_filename);

                TrackerClient tracker = new TrackerClient();
                TrackerServer trackerServer = tracker.getConnection();
                StorageServer storageServer = null;

                StorageClient storageClient = new StorageClient(trackerServer,
                        storageServer);
                NameValuePair nvps [] = storageClient.get_metadata("group1", "M00/00/00/wKgRcFV_08OAK_KCAAAA5fm_sy874.conf");
                for(NameValuePair nvp : nvps){
                    System.out.println(nvp.getName() + ":" + nvp.getValue());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Test
        public void testDelete(){
            try {
                ClientGlobal.init(conf_filename);

                TrackerClient tracker = new TrackerClient();
                TrackerServer trackerServer = tracker.getConnection();
                StorageServer storageServer = null;

                StorageClient storageClient = new StorageClient(trackerServer,
                        storageServer);
                int i = storageClient.delete_file("group1", "M00/00/00/wKgRcFV_08OAK_KCAAAA5fm_sy874.conf");
                System.out.println( i==0 ? "删除成功" : "删除失败:"+i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
