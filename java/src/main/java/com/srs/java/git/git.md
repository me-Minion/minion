# GIT

## 本地git实现多账户连接GitLab、GitHub
思路：
- GitLab、GitHub分别根据账户生成私钥、公钥
    - 默认生成路径为：（MAC）~/.ssh | （WIN）c:/Users/Administrator/.ssh
    - 生成秘钥指令：ssh-keygen -t rsa -C "你的邮箱"
    - 生成秘钥文件名称不能重复，可以指定为id_rsa_hub、id_rsa_hub.pub或者id_rsa_lab、id_rsa_lab.pub
- 清空know_hosts
  - 在.ssh中创建config文件，保存GitLab、GitHub的账户信息 

```
Host github.com
    HostName    github.com
    User    github
    IdentityFile    ~/.ssh/id_rsa_hub
    
Host gitlab.test.com
    HostName    gitlab.test.com
    User    gitlab
    IdentityFile    ~/.ssh/id_rsa_lab
```
- 测试验证
  - ssh -T git@github.com 
  
  ![avatar](./pic/github1.jpg)
  - ssh -T git@gitlab.com
  
  ![avatar](./pic/gitlab1.png)
  
  ## 本地代码和远程仓库关联
  
https://github.com/me-Minion/minion.git