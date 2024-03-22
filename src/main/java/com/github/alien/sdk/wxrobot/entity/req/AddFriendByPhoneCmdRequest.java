package com.github.alien.sdk.wxrobot.entity.req;

import com.github.alien.sdk.wxrobot.entity.AbsCmdWorktoolRequest;
import com.github.alien.sdk.wxrobot.entity.IRobtCmd;
import com.github.alien.sdk.wxrobot.entity.res.BaseCmdWorktoolResponse;

import java.io.Serializable;
import java.util.List;

/**
 * 根据手机号添加好友指令请求
 * <br/>
 *
 * @author alien at 2024/3/22 10:32
 */
public class AddFriendByPhoneCmdRequest extends AbsCmdWorktoolRequest<AddFriendByPhoneCmdRequest.Detail, BaseCmdWorktoolResponse> {
    public AddFriendByPhoneCmdRequest() {
        super();
    }

    public AddFriendByPhoneCmdRequest(String... phones) {
        this();
        for (String phone : phones) {
            Detail detail = new Detail();
            detail.friend = new Friend(phone);
            getList().add(detail);
        }
    }

    public static class Detail implements IRobtCmd {
        private Friend friend;

        @Override
        public long getType() {
            return INSTRUCTION_ARR[4];
        }

        public Friend getFriend() {
            return friend;
        }

        public void setFriend(Friend friend) {
            this.friend = friend;
        }
    }

    public static class Friend implements Serializable {
        public Friend(String phone) {
            this.phone = phone;
        }

        /**
         * 加好友附言
         */
        private String leavingMsg;
        /**
         * 备注其他信息(不推荐) 选填
         */
        private String markExtra;
        /**
         * 备注昵称 选填
         */
        private String markName;
        /**
         * 按手机号搜索
         */
        private String phone;
        /**
         * 备注标签(推荐) 选填
         */
        private List<String> tagList;

        public String getLeavingMsg() {
            return leavingMsg;
        }

        public void setLeavingMsg(String leavingMsg) {
            this.leavingMsg = leavingMsg;
        }

        public String getMarkExtra() {
            return markExtra;
        }

        public void setMarkExtra(String markExtra) {
            this.markExtra = markExtra;
        }

        public String getMarkName() {
            return markName;
        }

        public void setMarkName(String markName) {
            this.markName = markName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public List<String> getTagList() {
            return tagList;
        }

        public void setTagList(List<String> tagList) {
            this.tagList = tagList;
        }
    }
}