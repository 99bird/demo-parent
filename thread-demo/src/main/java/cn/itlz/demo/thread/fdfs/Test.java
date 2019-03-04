package cn.itlz.demo.thread.fdfs;

import org.csource.fastdfs.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {



	public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
		// 1.加载配置文件
		ClientGlobal.init("D:\\proj\\demo-parent\\thread-demo\\src\\main\\resources\\fdfs_client.conf");
		// 2.构建一个管理者客户端
		TrackerClient client=new TrackerClient();
		// 3.连接管理者服务端
		TrackerServer trackerServer = client.getConnection();
		//4. 声明存储服务端
		StorageServer storageServer=null;
		//5. 获取存储服务器的客户端对象
		StorageClient storageClient=new StorageClient(trackerServer, storageServer);
		//6.上传文件
		String[] strings = storageClient.upload_file("D:\\my\\timdf.jpg", "jpg", null);
		//7.显示上传结果 file_id
		for(String str:strings){
			System.out.println(str);
		}

		/*String conf_filename = "D:\\proj\\demo-parent\\thread-demo\\src\\main\\resources\\fdfs_client.conf";
        //public String local_filename = "D:\\stsworkspace\\fastdfs-demo\\src\\main\\resources\\fdfs_client.conf";

        String local_filename = "D:\\my\\timg.jpg";

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
        }*/
		
	}

}
