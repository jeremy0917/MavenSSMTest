package com.yjy.maven.bean;

public class UserKey {
    private Long userId;

    private Short partitionId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Short getPartitionId() {
        return partitionId;
    }

    public void setPartitionId(Short partitionId) {
        this.partitionId = partitionId;
    }
}