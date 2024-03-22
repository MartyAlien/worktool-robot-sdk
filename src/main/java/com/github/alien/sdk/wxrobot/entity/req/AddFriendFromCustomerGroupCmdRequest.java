package com.github.alien.sdk.wxrobot.entity.req;

import com.github.alien.sdk.wxrobot.entity.AbsCmdWorktoolRequest;
import com.github.alien.sdk.wxrobot.entity.IRobtCmd;
import com.github.alien.sdk.wxrobot.entity.res.BaseCmdWorktoolResponse;

import java.io.Serializable;
import java.util.List;

/**
 * 从客户群添加好友指令请求
 * <br/>
 *
 * @author alien at 2024/3/22 11:04
 */
public class AddFriendFromCustomerGroupCmdRequest extends AbsCmdWorktoolRequest<AddFriendFromCustomerGroupCmdRequest.Detail, BaseCmdWorktoolResponse> {
    public AddFriendFromCustomerGroupCmdRequest() {
        super();
    }

    public AddFriendFromCustomerGroupCmdRequest(List<Detail> list) {
        super(list);
    }

    public AddFriendFromCustomerGroupCmdRequest(Detail... details) {
        this();
        for (Detail detail : details) {
            getList().add(detail);
        }
    }

    public AddFriendFromCustomerGroupCmdRequest(String groupName, String... friendNames) {
        this();
        for (String friendName : friendNames) {
            Detail detail = new Detail();
            detail.groupName = groupName;
            detail.friend = new Friend(friendName);
            getList().add(detail);
        }
    }

    public static class Detail implements IRobtCmd {
        /**
         * 朋友
         */
        private Friend friend;
        /**
         * 群名或群备注名
         */
        private String groupName;

        @Override
        public long getType() {
            return INSTRUCTION_ARR[5];
        }

        public Friend getFriend() {
            return friend;
        }

        public void setFriend(Friend friend) {
            this.friend = friend;
        }

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }
    }

    public static class Friend implements Serializable {
        public Friend(String name) {
            this.name = name;
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
         * 昵称或备注名
         */
        private String name;
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getTagList() {
            return tagList;
        }

        public void setTagList(List<String> tagList) {
            this.tagList = tagList;
        }
    }
}
