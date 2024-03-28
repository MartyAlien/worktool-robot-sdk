package com.github.alien.sdk.wxrobot.entity.req;

import com.github.alien.sdk.wxrobot.entity.AbsCmdWorktoolRequest;
import com.github.alien.sdk.wxrobot.entity.IRobtCmd;
import com.github.alien.sdk.wxrobot.entity.res.BaseCmdWorktoolResponse;

import java.io.Serializable;

/**
 * 修改群成员备注请求
 * <br/>
 *
 * @author alien at 2024/3/28 11:10
 */
public class ModifyGroupMemberMarkCmdRequest extends AbsCmdWorktoolRequest<ModifyGroupMemberMarkCmdRequest.Detail, BaseCmdWorktoolResponse> {

    public ModifyGroupMemberMarkCmdRequest() {
        super();
    }

    public ModifyGroupMemberMarkCmdRequest(Detail... details) {
        this();
        this.getList().add(details[0]);
    }


    public static class Detail implements IRobtCmd {

        /**
         * 群名称
         */
        private String groupName;
        /**
         * 群成员
         */
        private Friend friend;

        public Detail() {
        }

        public Detail(String groupName, Friend friend) {
            this.groupName = groupName;
            this.friend = friend;
        }

        public Detail(String groupName, String name, String markName) {
            this.groupName = groupName;
            this.friend = new Friend(name, markName);
        }

        public String getGroupName() {
            return groupName;
        }

        public Friend getFriend() {
            return friend;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public void setFriend(Friend friend) {
            this.friend = friend;
        }

        @Override
        public long getType() {
            return INSTRUCTION_ARR[12];
        }
    }

    public static class Friend implements Serializable {
        /**
         * 昵称
         */
        private String name;
        /**
         * 备注名
         */
        private String markName;

        public Friend(String name, String mark) {
            this.name = name;
            this.markName = mark;
        }

        public String getName() {
            return name;
        }

        public String getMarkName() {
            return markName;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setMarkName(String markName) {
            this.markName = markName;
        }
    }

}
