package com.github.alien.sdk.wxrobot.entity.req;

import com.github.alien.sdk.wxrobot.entity.AbsCmdWorktoolRequest;
import com.github.alien.sdk.wxrobot.entity.IRobtCmd;
import com.github.alien.sdk.wxrobot.entity.res.BaseCmdWorktoolResponse;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 修改群信息（可拉/踢人）请求
 * <br/>
 *
 * @author alien at 2024/3/25 10:40
 */
public class ModifyCustomGroupCmdRequest extends AbsCmdWorktoolRequest<ModifyCustomGroupCmdRequest.Detail, BaseCmdWorktoolResponse> {
    public ModifyCustomGroupCmdRequest() {
        super();
    }

    public ModifyCustomGroupCmdRequest(Detail... list) {
        this();
        this.getList().addAll(Arrays.asList(list));
    }

    public static class Detail implements IRobtCmd {
        public Detail(String groupName) {
            this.groupName = groupName;
        }

        /**
         * 待修改的群名(有备注的使用备注名)
         */
        private String groupName;
        /**
         * 修改群备注(选填)
         */
        private String groupRemark;
        /**
         * 修改群模板(选填)
         */
        private String groupTemplate;
        /**
         * 修改群公告 选填
         */
        private String newGroupAnnouncement;
        /**
         * 修改群名 选填
         */
        private String newGroupName;
        /**
         * 移除群成员名称列表/踢人 选填
         */
        private Set<String> removeList;
        /**
         * 添加群成员名称列表/拉人 选填
         */
        private Set<String> selectList;
        /**
         * 拉人是否附带历史记录 选填
         */
        private Boolean showMessageHistory;

        @Override
        public long getType() {
            return INSTRUCTION_ARR[6];
        }

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public String getGroupRemark() {
            return groupRemark;
        }

        public void setGroupRemark(String groupRemark) {
            this.groupRemark = groupRemark;
        }

        public String getGroupTemplate() {
            return groupTemplate;
        }

        public void setGroupTemplate(String groupTemplate) {
            this.groupTemplate = groupTemplate;
        }

        public String getNewGroupAnnouncement() {
            return newGroupAnnouncement;
        }

        public void setNewGroupAnnouncement(String newGroupAnnouncement) {
            this.newGroupAnnouncement = newGroupAnnouncement;
        }

        public String getNewGroupName() {
            return newGroupName;
        }

        public void setNewGroupName(String newGroupName) {
            this.newGroupName = newGroupName;
        }

        public Set<String> getRemoveList() {
            return removeList;
        }

        public void setRemoveList(String... removes) {
            if (this.removeList == null) {
                this.removeList = new HashSet<>();
            }
            this.removeList.addAll(Arrays.asList(removes));
        }

        public void setRemoveList(Set<String> removeList) {
            this.removeList = removeList;
        }

        public Set<String> getSelectList() {
            return selectList;
        }

        public void setSelectList(String... selects) {
            if (this.selectList == null) {
                this.selectList = new HashSet<>();
            }
            this.selectList.addAll(Arrays.asList(selects));
        }

        public void setSelectList(Set<String> selectList) {
            this.selectList = selectList;
        }

        public Boolean getShowMessageHistory() {
            return showMessageHistory;
        }

        public void setShowMessageHistory(Boolean showMessageHistory) {
            this.showMessageHistory = showMessageHistory;
        }
    }
}
