package com.ghostchu.peerbanhelper.downloader;

import com.ghostchu.peerbanhelper.peer.Peer;
import com.ghostchu.peerbanhelper.torrent.Torrent;
import com.ghostchu.peerbanhelper.wrapper.PeerAddress;

import java.util.Collection;
import java.util.List;

public interface Downloader extends AutoCloseable{
    String getEndpoint();
    String getName();

    /**
     * 登录到此下载器
     * @return 登陆是否成功
     */
    boolean login();

    /**
     * 获取此下载器的所有目前正在活动的 Torrent 列表
     * @return 返回所有活动的 Torrents
     */
    List<Torrent> getTorrents();

    /**
     * 获取指定 Torrent 的对等体列表
     * @param torrentId Torrent 唯一标识符
     * @return 对等体列表
     */
    List<Peer> getPeers(String torrentId);

    /**
     * 获取此下载器已设置的 BanList
     * @return BanList
     */
    List<PeerAddress> getBanList();

    /**
     * 设置并使新的 BanList 生效
     * @param peerAddresses BanList
     */
    void setBanList(Collection<PeerAddress> peerAddresses);
}