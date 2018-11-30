package cmpe275.dos.controller;

import cmpe275.dos.entity.User;
import cmpe275.dos.response.JsonResponse;
import cmpe275.dos.service.UserService;

import static cmpe275.dos.constant.UrlConstant.USER;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@Api(tags = {"User"})
@SwaggerDefinition(tags = {@Tag(name = "User Controller", description = "User Controller Endpoint")})
@Transactional(rollbackFor = Exception.class)
public class UserController extends AbstractController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "Get All Users", response = Page.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")
    })
    @GetMapping(USER + "S")
    public Page<User> getUser(Pageable pageable) {
        return userService.getAllUsers(pageable);
    }
}
