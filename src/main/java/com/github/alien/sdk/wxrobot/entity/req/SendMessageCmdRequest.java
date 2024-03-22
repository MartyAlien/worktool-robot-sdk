package com.github.alien.sdk.wxrobot.entity.req;

import com.github.alien.sdk.wxrobot.entity.AbsCmdWorktoolRequest;
import com.github.alien.sdk.wxrobot.entity.IRobtCmd;
import com.github.alien.sdk.wxrobot.entity.res.BaseCmdWorktoolResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 发送原始消息
 * <br/>
 *
 * @author alien at 2024/3/19 17:36
 */
public class SendMessageCmdRequest extends AbsCmdWorktoolRequest<SendMessageCmdRequest.Detail, BaseCmdWorktoolResponse> {
    public SendMessageCmdRequest() {
        super();
    }

    public SendMessageCmdRequest(List<Detail> list) {
        super(list);
    }

    public static class Detail implements IRobtCmd {
        /**
         * At所有人
         */
        public static final String AT_ALL = "@所有人";
        /**
         * at的人(at所有人用"@所有人")
         */
        private List<String> atList;
        /**
         * 发送文本内容 (\n换行)
         */
        private String receivedContent;
        /**
         * 昵称或群名
         */
        private List<String> titleList;

        public List<String> getAtList() {
            return atList;
        }

        public void setAtList(String... ats) {
            if (this.atList == null) {
                this.atList = new ArrayList<>();
            }
            this.atList.addAll(Arrays.asList(ats));
        }

        public void setAtList(List<String> atList) {
            this.atList = atList;
        }

        public String getReceivedContent() {
            return receivedContent;
        }

        public void setReceivedContent(String receivedContent) {
            this.receivedContent = receivedContent;
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

        public long getType() {
            return INSTRUCTION_ARR[0];
        }
    }
}
