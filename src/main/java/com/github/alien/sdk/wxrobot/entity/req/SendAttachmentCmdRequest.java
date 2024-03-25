package com.github.alien.sdk.wxrobot.entity.req;

import com.github.alien.sdk.wxrobot.entity.AbsCmdWorktoolRequest;
import com.github.alien.sdk.wxrobot.entity.IRobtCmd;
import com.github.alien.sdk.wxrobot.entity.res.BaseCmdWorktoolResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 推送任意图片/音视频/文件请求
 * <br/>
 *
 * @author alien at 2024/3/25 11:11
 */
public class SendAttachmentCmdRequest extends AbsCmdWorktoolRequest<SendAttachmentCmdRequest.Detail, BaseCmdWorktoolResponse> {
    public SendAttachmentCmdRequest() {
        super();
    }

    public SendAttachmentCmdRequest(Detail... details) {
        this();
        this.getList().addAll(Arrays.asList(details));
    }

    public static class Detail implements IRobtCmd {
        public Detail(FileType fileType, String fileUrl, String objectName, String... titles) {
            if (fileType == null) {
                throw new IllegalArgumentException("fileType can not be null");
            }
            if (fileUrl == null) {
                throw new IllegalArgumentException("fileUrl can not be null");
            }
            if (objectName == null) {
                throw new IllegalArgumentException("objectName can not be null");
            }
            this.fileType = fileType.type;
            this.fileUrl = fileUrl;
            this.objectName = objectName;
            this.setTitleList(titles);
        }

        /**
         * 附加留言 选填
         */
        private String extraText;
        /**
         * 文件类型（图片=image 音频=audio 视频=video 其他=*）
         */
        private String fileType;
        /**
         * 网络文件地址
         */
        private String fileUrl;
        /**
         * 文件名称（自定义）
         */
        private String objectName;
        /**
         * 待发送姓名
         */
        private List<String> titleList;

        @Override
        public long getType() {
            return INSTRUCTION_ARR[7];
        }

        public String getExtraText() {
            return extraText;
        }

        public void setExtraText(String extraText) {
            this.extraText = extraText;
        }

        public String getFileType() {
            return fileType;
        }

        public void setFileType(String fileType) {
            this.fileType = fileType;
        }

        public void setFileType(FileType fileType) {
            if (fileType != null) {
                this.setFileType(fileType.getType());
            }
        }

        public String getFileUrl() {
            return fileUrl;
        }

        public void setFileUrl(String fileUrl) {
            this.fileUrl = fileUrl;
        }

        public String getObjectName() {
            return objectName;
        }

        public void setObjectName(String objectName) {
            this.objectName = objectName;
        }

        public List<String> getTitleList() {
            return titleList;
        }

        public void setTitleList(String... titles) {
            if (this.titleList == null) {
                this.titleList = new ArrayList<>();
            }
            this.titleList.addAll(Arrays.asList(titles));
        }

        public void setTitleList(List<String> titleList) {
            this.titleList = titleList;
        }
    }

    public enum FileType {
        IMAGE("image", "图片"),
        AUDIO("audio", "音频"),
        VIDEO("video", "视频"),
        OTHER("*", "其他文件");

        private final String type;
        private final String name;

        FileType(String type, String name) {
            this.type = type;
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public String getName() {
            return name;
        }
    }
}
