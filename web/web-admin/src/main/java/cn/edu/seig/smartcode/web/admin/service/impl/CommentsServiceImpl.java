package cn.edu.seig.smartcode.web.admin.service.impl;

import cn.edu.seig.smartcode.model.entity.Comments;
import cn.edu.seig.smartcode.web.admin.mapper.CommentsMapper;
import cn.edu.seig.smartcode.web.admin.service.CommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* @author 86135
* @description 针对表【comments(评论表)】的数据库操作Service实现
* @createDate 2024-11-16 20:40:26
*/
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments>
    implements CommentsService {

}




