package com.github.alien.sdk.wxrobot.entity.req;

import com.github.alien.sdk.wxrobot.entity.AbsCmdWorktoolRequest;
import com.github.alien.sdk.wxrobot.entity.IRobtCmd;
import com.github.alien.sdk.wxrobot.entity.res.BaseCmdWorktoolResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 推送微盘图片请求
 * <br/>
 *
 * @author alien at 2024/3/28 10:16
 */
public class PushWepanImgCmdRequest extends AbsCmdWorktoolRequest<PushWepanImgCmdRequest.Detail, BaseCmdWorktoolResponse> {
    public PushWepanImgCmdRequest() {
        super();
    }

    public PushWepanImgCmdRequest(Detail... details) {
        this();
        this.getList().addAll(Arrays.asList(details));
    }

    public static class Detail implements IRobtCmd {

        /**
         * 待发送姓名
         */
        private List<String> titleList;
        /**
         * 微盘图片的objectName
         */
        private String objectName;
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
            return INSTRUCTION_ARR[9];
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
