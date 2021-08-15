package com.yunlian.changgou.service.file.util;

import com.yunlian.changgou.service.file.model.FastDFSFile;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FastDFSClient {

    static {
        String filePath = new ClassPathResource("fdfs_client.conf").getPath();
        try {
            ClientGlobal.init(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public TrackerServer getTrackerServer() throws IOException {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer server = trackerClient.getConnection();
        return server;
    }

    public StorageClient getStorageClient() throws IOException {
        TrackerServer trackerServer = getTrackerServer();
        StorageClient client = new StorageClient(trackerServer,null);
        return client;
    }

    public String[] upload(FastDFSFile fastDFSFile) throws Exception {
        NameValuePair[] meta_list = new NameValuePair[1];
        meta_list[0] =new NameValuePair();
        String[] str = null;
        StorageClient client = getStorageClient();
        System.out.println(fastDFSFile.getContent());
        System.out.println(fastDFSFile.getExt());
        System.out.println(meta_list);
        str = client.upload_file(fastDFSFile.getContent(),fastDFSFile.getExt(),meta_list);
        return str;
    }

    public String getTrackerUrl() throws IOException {
        TrackerServer trackerServer = getTrackerServer();
        return "http://"+trackerServer.getInetSocketAddress().getHostString()+":"+ClientGlobal.getG_tracker_http_port();
    }

    public byte[] download(String groupName,String remoteFileName) throws Exception {
        StorageClient storageClient = getStorageClient();
        return storageClient.download_file(groupName,remoteFileName);
    }

    public boolean deleteFile(String groupName, String remoteFileName) throws Exception {
        StorageClient storageClient =getStorageClient();
        if(storageClient.delete_file(groupName,remoteFileName)==0){
            return true;
        }else {
            return false;
        }
    }
}
