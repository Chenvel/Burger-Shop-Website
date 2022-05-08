<!-- header-start -->
<header>
  <div class="header-area ">
    <div id="sticky-header" class="main-header-area">
      <div class="container-fluid p-0">
        <div class="row align-items-center no-gutters">
          <div class="col-xl-5 col-lg-5">
            <div class="main-menu  d-none d-lg-block">
              <nav>
                <ul id="navigation">
                  <li><a class="${springMacroRequestContext.requestUri?matches("/")?then("active", "")}" href="/">home</a></li>
                  <li><a class="${springMacroRequestContext.requestUri?contains("/menu")?then("active", "")}" href="/menu">Menu</a></li>
                  <li><a class="${springMacroRequestContext.requestUri?contains("/about")?then("active", "")}" href="/about">About</a></li>
                  <li><a class="${springMacroRequestContext.requestUri?contains("/blog")?then("active", "")}" href="/blog">blog</a></li>
                  <li><a class="${springMacroRequestContext.requestUri?contains("/contact")?then("active", "")}" href="/contact">Contact</a></li>
                </ul>
              </nav>
            </div>
          </div>
          <div class="col-xl-2 col-lg-2">
            <div class="logo-img">
              <a href="/">
                <img src="/static/img/logo.png" alt="">
              </a>
            </div>
          </div>
          <div class="col-xl-5 col-lg-5 d-none d-lg-block">
            <div class="book_room">
              <div class="socail_links">
                <ul>
                  <li>
                    <a href="https://instagram.com">
                      <i class="fa fa-instagram"></i>
                    </a>
                  </li>
                  <li>
                    <a href="https://twitter.com">
                      <i class="fa fa-twitter"></i>
                    </a>
                  </li>
                  <li>
                    <a href="https://facebook.com">
                      <i class="fa fa-facebook"></i>
                    </a>
                  </li>
                  <li>
                    <a href="https://google.com">
                      <i class="fa fa-google-plus"></i>
                    </a>
                  </li>
                </ul>
              </div>
              <div class="book_btn d-none d-xl-block">
                <a class="#" href="#">+10 367 453 7382</a>
              </div>
            </div>
          </div>
          <div class="col-12">
            <div class="mobile_menu d-block d-lg-none"></div>
          </div>
        </div>
      </div>
    </div>
  </div>
</header>
<!-- header-end -->