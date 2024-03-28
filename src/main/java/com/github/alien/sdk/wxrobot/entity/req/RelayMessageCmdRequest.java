package com.github.alien.sdk.wxrobot.entity.req;

import com.github.alien.sdk.wxrobot.entity.AbsCmdWorktoolRequest;
import com.github.alien.sdk.wxrobot.entity.IRobtCmd;
import com.github.alien.sdk.wxrobot.entity.res.BaseCmdWorktoolResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 转发消息请求
 * <br/>
 *
 * @author alien at 2024/3/25 13:43
 */
public class RelayMessageCmdRequest extends AbsCmdWorktoolRequest<RelayMessageCmdRequest.Detail, BaseCmdWorktoolResponse> {
    public RelayMessageCmdRequest() {
        super();
    }

    public RelayMessageCmdRequest(RelayMessageCmdRequest.Detail... details) {
        this();
        this.getList().addAll(Arrays.asList(details));
    }

    public static class Detail implements IRobtCmd {
        /**
         * 附加留言 选填
         */
        private String extraText;
        /**
         * 待转发姓名列表
         */
        private List<String> nameList;
        /**
         * 原始消息的内容（如公众号名称）
         */
        private String originalContent;
        /**
         * 原始消息的发送人昵称
         */
        private String receivedName;
        /**
         * 消息类型 0=未知 1=文本 2=图片 5=视频 7=小程序 8=链接 9=文件
         */
        private Long textType;
        /**
         * 转发群群名
         */
        private List<String> titleList;

        @Override
        public long getType() {
            return INSTRUCTION_ARR[8];
        }

        public String getExtraText() {
            return extraText;
        }

        public void setExtraText(String extraText) {
            this.extraText = extraText;
        }

        public List<String> getNameList() {
            return nameList;
        }

        public void setNameList(String... names) {
            if (this.nameList == null) {
                this.nameList = new ArrayList<>();
            }
            this.nameList.addAll(Arrays.asList(names));
        }

        public void setNameList(List<String> nameList) {
            this.nameList = nameList;
        }

        public String getOriginalContent() {
            return originalContent;
        }

        public void setOriginalContent(String originalContent) {
            this.originalContent = originalContent;
        }

        public String getReceivedName() {
            return receivedName;
        }

        public void setReceivedName(String receivedName) {
            this.receivedName = receivedName;
        }

        public Long getTextType() {
            return textType;
        }

        public void setTextType(TextType textType) {
            if (textType != null) {
                this.setTextType(textType.getType());
            } else {
                this.setTextType(TextType.UNKNOWN.getType());
            }
        }

        public void setTextType(Long textType) {
            this.textType = textType;
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

    public enum TextType {
        UNKNOWN(0, "未知"),
        TEXT(1, "文本"),
        IMAGE(2, "图片"),
        VIDEO(5, "视频"),
        MINI_PROGRAM(7, "小程序"),
        LINK(8, "链接"),
        FILE(9, "文件");

        private final Long type;
        private final String name;

        TextType(long type, String name) {
            this.type = type;
            this.name = name;
        }

        public long getType() {
            return type;
        }

        public String getName() {
            return name;
        }
    }
}
