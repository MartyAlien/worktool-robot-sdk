package com.github.alien.sdk.wxrobot.entity.req;

import com.github.alien.sdk.wxrobot.entity.AbsCmdWorktoolRequest;
import com.github.alien.sdk.wxrobot.entity.IRobtCmd;
import com.github.alien.sdk.wxrobot.entity.res.BaseCmdWorktoolResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 添加代办给企业内部成员请求
 * <br/>
 *
 * @author alien at 2024/3/28 11:37
 */
public class AddTodoCmdRequest extends AbsCmdWorktoolRequest<AddTodoCmdRequest.Detail, BaseCmdWorktoolResponse> {

    public AddTodoCmdRequest() {
        super();
    }

    public AddTodoCmdRequest(Detail... details) {
        this();
        this.getList().add(details[0]);
    }

    public static class Detail implements IRobtCmd {
        /**
         * 待办事项内容
         */
        private String receivedContent;

        /**
         * 内部用户昵称
         */
        private List<String> titleList;

        public Detail(String receivedContent, List<String> titleList) {
            this.receivedContent = receivedContent;
            this.titleList = titleList;
        }

        public Detail(String receivedContent, String... titles) {
            this.receivedContent = receivedContent;
            this.setTitleList(titles);
        }

        @Override
        public long getType() {
            return INSTRUCTION_ARR[13];
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

        public String getReceivedContent() {
            return receivedContent;
        }

        public void setReceivedContent(String receivedContent) {
            this.receivedContent = receivedContent;
        }
    }
}
