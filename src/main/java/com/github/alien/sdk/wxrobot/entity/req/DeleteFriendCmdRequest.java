package com.github.alien.sdk.wxrobot.entity.req;

import com.github.alien.sdk.wxrobot.entity.AbsCmdWorktoolRequest;
import com.github.alien.sdk.wxrobot.entity.IRobtCmd;
import com.github.alien.sdk.wxrobot.entity.res.BaseCmdWorktoolResponse;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 删除联系人请求
 * <br/>
 *
 * @author alien at 2024/3/28 11:43
 */
public class DeleteFriendCmdRequest extends AbsCmdWorktoolRequest<DeleteFriendCmdRequest.Detail, BaseCmdWorktoolResponse> {
    public DeleteFriendCmdRequest() {
        super();
    }

    public DeleteFriendCmdRequest(Detail... details) {
        this();
        this.getList().addAll(Arrays.asList(details));
    }

    public DeleteFriendCmdRequest(String... friendName) {
        this();
        for (String name : friendName) {
            Detail detail = new Detail(name);
            getList().add(detail);
        }
    }

    public static class Detail implements IRobtCmd {

        /**
         * 待删除好友
         */
        private Friend friend;

        public Detail() {
        }

        public Detail(Friend friend) {
            this.friend = friend;
        }

        public Detail(String friendName) {
            this.friend = new Friend(friendName);
        }

        @Override
        public long getType() {
            return INSTRUCTION_ARR[14];
        }

        public Friend getFriend() {
            return friend;
        }

        public void setFriend(Friend friend) {
            this.friend = friend;
        }
    }

    public static class Friend implements Serializable {
        public Friend(String name) {
            this.name = name;
        }


        /**
         * 昵称或备注名
         */
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
