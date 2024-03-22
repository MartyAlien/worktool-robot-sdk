package com.github.alien.sdk.wxrobot.entity.req;

import com.github.alien.sdk.wxrobot.entity.AbsCmdWorktoolRequest;
import com.github.alien.sdk.wxrobot.entity.IRobtCmd;
import com.github.alien.sdk.wxrobot.entity.res.BaseCmdWorktoolResponse;

import java.util.List;

/**
 * 批量调用指令请求
 * <br/>
 *
 * @author alien at 2024/3/22 10:03
 */
public class BatchCallCmdRequest extends AbsCmdWorktoolRequest<IRobtCmd, BaseCmdWorktoolResponse> {
    public BatchCallCmdRequest() {
        super();
    }

    public BatchCallCmdRequest(List<? extends IRobtCmd> list) {
        this();
        getList().addAll(list);
    }

    public BatchCallCmdRequest(IRobtCmd... cmds) {
        this();
        for (IRobtCmd cmd : cmds) {
            getList().add(cmd);
        }
    }
}
