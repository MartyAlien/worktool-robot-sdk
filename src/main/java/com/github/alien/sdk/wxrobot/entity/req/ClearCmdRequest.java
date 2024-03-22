package com.github.alien.sdk.wxrobot.entity.req;

import com.github.alien.sdk.wxrobot.entity.AbsCmdWorktoolRequest;
import com.github.alien.sdk.wxrobot.entity.IRobtCmd;
import com.github.alien.sdk.wxrobot.entity.res.BaseCmdWorktoolResponse;

/**
 * 清空指令请求
 * <br/>
 *
 * @author alien at 2024/3/20 16:53
 */
public class ClearCmdRequest extends AbsCmdWorktoolRequest<ClearCmdRequest.Detail, BaseCmdWorktoolResponse> {
    public ClearCmdRequest() {
        this.getList().add(new Detail());
    }

    public static class Detail implements IRobtCmd {
        public long getType() {
            return INSTRUCTION_ARR[3];
        }
    }

}
