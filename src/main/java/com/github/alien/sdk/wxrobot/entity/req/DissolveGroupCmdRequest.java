package com.github.alien.sdk.wxrobot.entity.req;

import com.github.alien.sdk.wxrobot.entity.AbsCmdWorktoolRequest;
import com.github.alien.sdk.wxrobot.entity.IRobtCmd;
import com.github.alien.sdk.wxrobot.entity.res.BaseCmdWorktoolResponse;

import java.util.List;

/**
 * 解散群请求
 * <br/>
 *
 * @author alien at 2024/3/20 10:02
 */
public class DissolveGroupCmdRequest extends AbsCmdWorktoolRequest<DissolveGroupCmdRequest.Detail, BaseCmdWorktoolResponse> {

    public DissolveGroupCmdRequest() {
        super();
    }

    public DissolveGroupCmdRequest(List<Detail> list) {
        super(list);
    }

    public DissolveGroupCmdRequest(String groupName) {
        this();
        getList().add(new Detail(groupName));
    }

    public static class Detail implements IRobtCmd {
        public Detail(String groupName) {
            this.groupName = groupName;
        }
        /**
         * 待解散的群名
         */
        private String groupName;

        public long getType() {
            return INSTRUCTION_ARR[2];
        }

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }
    }

}
