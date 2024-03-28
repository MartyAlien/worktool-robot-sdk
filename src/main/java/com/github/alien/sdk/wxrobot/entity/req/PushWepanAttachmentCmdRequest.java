package com.github.alien.sdk.wxrobot.entity.req;

import com.github.alien.sdk.wxrobot.entity.AbsCmdWorktoolRequest;
import com.github.alien.sdk.wxrobot.entity.IRobtCmd;
import com.github.alien.sdk.wxrobot.entity.res.BaseCmdWorktoolResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 推送微盘文件请求
 * <br/>
 *
 * @author alien at 2024/3/28 10:16
 */
public class PushWepanAttachmentCmdRequest extends AbsCmdWorktoolRequest<PushWepanAttachmentCmdRequest.Detail, BaseCmdWorktoolResponse> {
    public PushWepanAttachmentCmdRequest() {
        super();
    }

    public PushWepanAttachmentCmdRequest(Detail... details) {
        this();
        this.getList().addAll(Arrays.asList(details));
    }

    public static class Detail implements IRobtCmd {

        /**
         * 待发送姓名
         */
        private List<String> titleList;
        /**
         * 文件名称 (微盘里存在)
         */
        private String objectName;
        /**
         * 附加留言 选填
         */
        private String extraText;

        public Detail(String objectName, List<String> titleList) {
            this.objectName = objectName;
            this.titleList = titleList;
        }

        public Detail(String objectName, String... titles) {
            this.objectName = objectName;
            this.setTitleList(titles);
        }

        @Override
        public long getType() {
            return INSTRUCTION_ARR[11];
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

        public String getObjectName() {
            return objectName;
        }

        public void setObjectName(String objectName) {
            this.objectName = objectName;
        }

        public String getExtraText() {
            return extraText;
        }

        public void setExtraText(String extraText) {
            this.extraText = extraText;
        }
    }
}
