package com.github.alien.sdk.wxrobot.entity.req;

import com.github.alien.sdk.wxrobot.entity.AbsCmdWorktoolRequest;
import com.github.alien.sdk.wxrobot.entity.IRobtCmd;
import com.github.alien.sdk.wxrobot.entity.res.BaseCmdWorktoolResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 创建客户群请求
 * <br/>
 *
 * @author alien at 2024/3/20 10:02
 */
public class CreateCustomerGroupCmdRequest extends AbsCmdWorktoolRequest<CreateCustomerGroupCmdRequest.Detail, BaseCmdWorktoolResponse> {

    public CreateCustomerGroupCmdRequest() {
        super();
    }

    public CreateCustomerGroupCmdRequest(List<Detail> list) {
        super(list);
    }

    public static class Detail implements IRobtCmd {
        public Detail(String groupName) {
            this.groupName = groupName;
        }
        /**
         * 要创建的群名
         */
        private String groupName;
        /**
         * 要拉入群的成员昵称
         */
        private List<String> selectList;
        /**
         * 群的群公告(选填)
         */
        private String groupAnnouncement;
        /**
         * 修改群备注(选填)
         */
        private String groupRemark;

        public long getType() {
            return INSTRUCTION_ARR[1];
        }

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public List<String> getSelectList() {
            return selectList;
        }

        public void setSelectList(String... selects) {
            if (this.selectList == null) {
                this.selectList = new ArrayList<>();
            }
            this.selectList.addAll(Arrays.asList(selects));
        }

        public void setSelectList(List<String> selectList) {
            this.selectList = selectList;
        }

        public String getGroupAnnouncement() {
            return groupAnnouncement;
        }

        public void setGroupAnnouncement(String groupAnnouncement) {
            this.groupAnnouncement = groupAnnouncement;
        }

        public String getGroupRemark() {
            return groupRemark;
        }

        public void setGroupRemark(String groupRemark) {
            this.groupRemark = groupRemark;
        }
    }

}
