<#import "parts/common.ftlh" as p>

<@p.page>

    <!-- bradcam_area_start -->
    <div class="bradcam_area breadcam_bg">
        <h3>blog</h3>
    </div>
    <!-- bradcam_area_end -->

    <!--================Blog Area =================-->
    <section class="blog_area section-padding">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 mb-5 mb-lg-0">
                    <div class="blog_left_sidebar">
                        <#list blogs.content as blog>
                            <article class="blog_item">
                                <div class="blog_item_img">
                                    <img class="card-img rounded-0" src="/static/${blog.getImagePath()}" alt="">
                                    <a href="/static/#" class="blog_item_date">
                                        <h3 style="text-align: center;">${blog.getDay()}</h3>
                                        <p>${blog.getMonth()!}</p>
                                    </a>
                                </div>

                                <div class="blog_details">
                                    <a class="d-inline-block" href="/blog/${blog.getId()}">
                                        <h2>${blog.getName()}</h2>
                                    </a>
                                    <p>${blog.getDescription()}</p>
                                    <ul class="blog-info-link">
                                        <li>
                                            <a href="/static/#"><i class="fa fa-user"></i>
                                                <#list blog.getTags() as tag>
                                                    ${tag.getName()}<#sep>,
                                                </#list>
                                            </a>
                                        </li>
                                        <li><a href="/static/#"><i class="fa fa-comments"></i> ${blog.getReviewsSize()} Comments</a></li>
                                    </ul>
                                </div>
                            </article>
                        </#list>

                        <nav class="blog-pagination justify-content-center d-flex">
                            <ul class="pagination">
                                <li class="page-item">
                                    <a href="/blog?page=${blogs.getNumber() + 1}&size=1" class="page-link" aria-label="Previous">
                                        <i class="ti-angle-left"></i>
                                    </a>
                                </li>
                                <#if blogs.getNumber() lt 2>
                                    <#assign
                                    pag_pages = 1..4
                                    >

                                    <#else>
                                        <#assign
                                        pag_pages = (blogs.getNumber())..(blogs.getNumber() + 2)
                                        >
                                </#if>
                                <#if blogs.getNumber() gt blogs.getTotalPages() - 3>
                                    <#assign
                                    pag_pages = (blogs.getTotalPages() - 3)..blogs.getTotalPages()
                                    >
                                </#if>

                                <#if blogs.getNumber() gt 2 || blogs.getNumber() == 2>
                                    <li class="page-item">
                                        <a href="/blog?page=0&size=5" class="page-link">1</a>
                                    </li>
                                </#if>
                                <#list pag_pages as pag>
                                    <#if (pag - 1) == blogs.getNumber()>
                                        <li class="page-item active">
                                            <a href="#" class="page-link">${pag}</a>
                                        </li>

                                        <#else>
                                            <li class="page-item">
                                                <a href="/blog?page=${pag - 1}&size=5" class="page-link">${pag}</a>
                                            </li>
                                    </#if>
                                </#list>
                                <#if blogs.getTotalPages() gt 2 && blogs.getNumber() lt blogs.getTotalPages() - 2>
                                    <li class="page-item">
                                        <a href="/blog?page=${blogs.getTotalPages() - 1}&size=5" class="page-link">${blogs.getTotalPages()}</a>
                                    </li>
                                </#if>
                                <li class="page-item">
                                    <a href="/blog?page=${blogs.getNumber() + 1}&size=5" class="page-link" aria-label="Next">
                                        <i class="ti-angle-right"></i>
                                    </a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="blog_right_sidebar">
                        <aside class="single_sidebar_widget popular_post_widget">
                            <h3 class="widget_title">Recent Post</h3>
                            <#list recent_blogs as blog>
                                <div class="media post_item">
                                    <img src="/static/${blog.getImagePath()}" alt="post" style="width: 80px; height: 80px;">
                                    <div class="media-body">
                                        <a href="/blog/${blog.getId()}">
                                            <h3>${blog.getShortName()}</h3>
                                        </a>
                                        <p>${blog.getDate()}</p>
                                    </div>
                                </div>
                            </#list>
                        </aside>
                        <aside class="single_sidebar_widget tag_cloud_widget">
                            <h4 class="widget_title">Tag Clouds</h4>
                            <ul class="list">
                                <#list tags as tag>
                                    <li>
                                        <a href="/static/#">${tag.getName()}</a>
                                    </li>
                                </#list>
                            </ul>
                        </aside>


                        <aside class="single_sidebar_widget instagram_feeds">
                            <h4 class="widget_title">Instagram Feeds</h4>
                            <ul class="instagram_row flex-wrap">
                                <li>
                                    <a href="/static/#">
                                        <img class="img-fluid" src="/static/img/post/post_5.png" alt="">
                                    </a>
                                </li>
                                <li>
                                    <a href="/static/#">
                                        <img class="img-fluid" src="/static/img/post/post_6.png" alt="">
                                    </a>
                                </li>
                                <li>
                                    <a href="/static/#">
                                        <img class="img-fluid" src="/static/img/post/post_7.png" alt="">
                                    </a>
                                </li>
                                <li>
                                    <a href="/static/#">
                                        <img class="img-fluid" src="/static/img/post/post_8.png" alt="">
                                    </a>
                                </li>
                                <li>
                                    <a href="/static/#">
                                        <img class="img-fluid" src="/static/img/post/post_9.png" alt="">
                                    </a>
                                </li>
                                <li>
                                    <a href="/static/#">
                                        <img class="img-fluid" src="/static/img/post/post_10.png" alt="">
                                    </a>
                                </li>
                            </ul>
                        </aside>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--================Blog Area =================-->
</@p.page>