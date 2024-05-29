<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" %>

  <%-- https://jakarta.ee/specifications/tags/3.0/tagdocs/index.html --> How to
    use Jakarta Standard Tag Library (JSTL)
    --%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>


      <!DOCTYPE html>
      <html>

        <head>
          <title>Homepage</title>
          <meta charset="utf-8">
          <meta name="viewport" content="width=device-width, initial-scale=1.0">
          <link rel="stylesheet" type="text/css"
            href="${pageContext.request.contextPath}/view/resources/css/bootstrap.min.css">
          <link rel="stylesheet" type="text/css"
            href="${pageContext.request.contextPath}/view/resources/css/style.css">
          <link rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
          <link rel="preconnect" href="https://fonts.googleapis.com">
          <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
          <link
            href="https://fonts.googleapis.com/css2?family=Jost:wght@300;400;500&family=Lato:wght@300;400;700&display=swap"
            rel="stylesheet">
          <!-- script
    ================================================== -->
          <script
            src="${pageContext.request.contextPath}/view/resources/js/modernizr.js"></script>
        </head>

        <body data-bs-spy="scroll" data-bs-target="#navbar"
          data-bs-root-margin="0px 0px -40%" data-bs-smooth-scroll="true"
          tabindex="0">

          <%-- inclue svg compon ent --%>
            <%@ include file="../component/svg.jsp" %>

              <%-- inclue searchPopup component --%>
                <%@ include file="../component/searchPopup.jsp" %>

                  <header id="header"
                    class="site-header header-scrolled position-fixed text-black bg-light">
                    <nav id="header-nav"
                      class="navbar navbar-expand-lg px-3 mb-3">
                      <div class="container-fluid">
                        <a class="navbar-brand" href="index.html">
                          <img
                            src="${pageContext.request.contextPath}/view/resources/images/main-logo.png"
                            class="logo">
                        </a>
                        <button
                          class="navbar-toggler d-flex d-lg-none order-3 p-2"
                          type="button" data-bs-toggle="offcanvas"
                          data-bs-target="#bdNavbar" aria-controls="bdNavbar"
                          aria-expanded="false" aria-label="Toggle navigation">
                          <svg class="navbar-icon">
                            <use xlink:href="#navbar-icon"></use>
                          </svg>
                        </button>
                        <div class="offcanvas offcanvas-end" tabindex="-1"
                          id="bdNavbar"
                          aria-labelledby="bdNavbarOffcanvasLabel">
                          <div class="offcanvas-header px-4 pb-0">
                            <a class="navbar-brand" href="index.html">
                              <img
                                src="${pageContext.request.contextPath}/view/resources/images/main-logo.png"
                                class="logo">
                            </a>
                            <button type="button"
                              class="btn-close btn-close-black"
                              data-bs-dismiss="offcanvas" aria-label="Close"
                              data-bs-target="#bdNavbar"></button>
                          </div>
                          <div class="offcanvas-body">
                            <ul id="navbar"
                              class="navbar-nav text-uppercase justify-content-end align-items-center flex-grow-1 pe-3">
                              <li class="nav-item">
                                <a class="nav-link me-4 active"
                                  href="#billboard">Home</a>
                              </li>
                              <li class="nav-item">
                                <a class="nav-link me-4"
                                  href="#company-services">Services</a>
                              </li>
                              <li class="nav-item">
                                <a class="nav-link me-4"
                                  href="#mobile-products">Products</a>
                              </li>
                              <li class="nav-item">
                                <a class="nav-link me-4"
                                  href="#smart-watches">Watches</a>
                              </li>
                              <li class="nav-item">
                                <a class="nav-link me-4"
                                  href="#yearly-sale">Sale</a>
                              </li>
                              <li class="nav-item">
                                <a class="nav-link me-4"
                                  href="#latest-blog">Blog</a>
                              </li>
                              <li class="nav-item dropdown">
                                <a class="nav-link me-4 dropdown-toggle link-dark"
                                  data-bs-toggle="dropdown" href="#"
                                  role="button" aria-expanded="false">Pages</a>
                                <ul class="dropdown-menu">
                                  <li>
                                    <a href="about.html"
                                      class="dropdown-item">About</a>
                                  </li>
                                  <li>
                                    <a href="blog.html"
                                      class="dropdown-item">Blog</a>
                                  </li>
                                  <li>
                                    <a href="shop.html"
                                      class="dropdown-item">Shop</a>
                                  </li>
                                  <li>
                                    <a href="cart.html"
                                      class="dropdown-item">Cart</a>
                                  </li>
                                  <li>
                                    <a href="checkout.html"
                                      class="dropdown-item">Checkout</a>
                                  </li>
                                  <li>
                                    <a href="single-post.html"
                                      class="dropdown-item">Single Post</a>
                                  </li>
                                  <li>
                                    <a href="single-product.html"
                                      class="dropdown-item">Single Product</a>
                                  </li>
                                  <li>
                                    <a href="contact.html"
                                      class="dropdown-item">Contact</a>
                                  </li>
                                </ul>
                              </li>
                              <li class="nav-item">
                                <div class="user-items ps-5">
                                  <ul
                                    class="d-flex justify-content-end list-unstyled">
                                    <li class="search-item pe-3">
                                      <a href="#" class="search-button">
                                        <svg class="search">
                                          <use xlink:href="#search"></use>
                                        </svg>
                                      </a>
                                    </li>
                                    <li class="pe-3">
                                      <a href="#">
                                        <svg class="user">
                                          <use xlink:href="#user"></use>
                                        </svg>
                                      </a>
                                    </li>
                                    <li>
                                      <a href="cart.html">
                                        <svg class="cart">
                                          <use xlink:href="#cart"></use>
                                        </svg>
                                      </a>
                                    </li>
                                  </ul>
                                </div>
                              </li>
                            </ul>
                          </div>
                        </div>
                      </div>
                    </nav>
                  </header>

                  <%-- inclue billboard component --%>
                    <%@ include file="../component/billboard.jsp" %>

                      <%-- inclue companyServices component --%>
                        <%@ include file="../component/companyServices.jsp" %>

                          <%-- inclue mobileProducts component --%>
                            <%@ include file="../component/mobileProducts.jsp"
                              %>

                              <%-- <section id="smart-watches"
                                class="product-store padding-large position-relative">
                                <div class="container">
                                  <div class="row">
                                    <div
                                      class="display-header d-flex justify-content-between pb-3">
                                      <h2
                                        class="display-7 text-dark text-uppercase">
                                        Smart Watches</h2>
                                      <div class="btn-right">
                                        <a href="shop.html"
                                          class="btn btn-medium btn-normal text-uppercase">Go
                                          to Shop</a>
                                      </div>
                                    </div>
                                    <div class="swiper product-watch-swiper">
                                      <div class="swiper-wrapper">
                                        <div class="swiper-slide">
                                          <div
                                            class="product-card position-relative">
                                            <div class="image-holder">
                                              <img
                                                src="images/product-item6.jpg"
                                                alt="product-item"
                                                class="img-fluid">
                                            </div>
                                            <div
                                              class="cart-concern position-absolute">
                                              <div class="cart-button d-flex">
                                                <a href="#"
                                                  class="btn btn-medium btn-black">Add
                                                  to Cart<svg
                                                    class="cart-outline">
                                                    <use
                                                      xlink:href="#cart-outline">
                                                    </use>
                                                  </svg></a>
                                              </div>
                                            </div>
                                            <div
                                              class="card-detail d-flex justify-content-between align-items-baseline pt-3">
                                              <h3
                                                class="card-title text-uppercase">
                                                <a href="#">Pink watch</a>
                                              </h3>
                                              <span
                                                class="item-price text-primary">$870</span>
                                            </div>
                                          </div>
                                        </div>
                                        <div class="swiper-slide">
                                          <div
                                            class="product-card position-relative">
                                            <div class="image-holder">
                                              <img
                                                src="images/product-item7.jpg"
                                                alt="product-item"
                                                class="img-fluid">
                                            </div>
                                            <div
                                              class="cart-concern position-absolute">
                                              <div class="cart-button d-flex">
                                                <a href="#"
                                                  class="btn btn-medium btn-black">Add
                                                  to Cart<svg
                                                    class="cart-outline">
                                                    <use
                                                      xlink:href="#cart-outline">
                                                    </use>
                                                  </svg></a>
                                              </div>
                                            </div>
                                            <div
                                              class="card-detail d-flex justify-content-between align-items-baseline pt-3">
                                              <h3
                                                class="card-title text-uppercase">
                                                <a href="#">Heavy watch</a>
                                              </h3>
                                              <span
                                                class="item-price text-primary">$680</span>
                                            </div>
                                          </div>
                                        </div>
                                        <div class="swiper-slide">
                                          <div
                                            class="product-card position-relative">
                                            <div class="image-holder">
                                              <img
                                                src="images/product-item8.jpg"
                                                alt="product-item"
                                                class="img-fluid">
                                            </div>
                                            <div
                                              class="cart-concern position-absolute">
                                              <div class="cart-button d-flex">
                                                <a href="#"
                                                  class="btn btn-medium btn-black">Add
                                                  to Cart<svg
                                                    class="cart-outline">
                                                    <use
                                                      xlink:href="#cart-outline">
                                                    </use>
                                                  </svg></a>
                                              </div>
                                            </div>
                                            <div
                                              class="card-detail d-flex justify-content-between align-items-baseline pt-3">
                                              <h3
                                                class="card-title text-uppercase">
                                                <a href="#">spotted watch</a>
                                              </h3>
                                              <span
                                                class="item-price text-primary">$750</span>
                                            </div>
                                          </div>
                                        </div>
                                        <div class="swiper-slide">
                                          <div
                                            class="product-card position-relative">
                                            <div class="image-holder">
                                              <img
                                                src="images/product-item9.jpg"
                                                alt="product-item"
                                                class="img-fluid">
                                            </div>
                                            <div
                                              class="cart-concern position-absolute">
                                              <div class="cart-button d-flex">
                                                <a href="#"
                                                  class="btn btn-medium btn-black">Add
                                                  to Cart<svg
                                                    class="cart-outline">
                                                    <use
                                                      xlink:href="#cart-outline">
                                                    </use>
                                                  </svg></a>
                                              </div>
                                            </div>
                                            <div
                                              class="card-detail d-flex justify-content-between align-items-baseline pt-3">
                                              <h3
                                                class="card-title text-uppercase">
                                                <a href="#">black watch</a>
                                              </h3>
                                              <span
                                                class="item-price text-primary">$650</span>
                                            </div>
                                          </div>
                                        </div>
                                        <div class="swiper-slide">
                                          <div
                                            class="product-card position-relative">
                                            <div class="image-holder">
                                              <img
                                                src="images/product-item10.jpg"
                                                alt="product-item"
                                                class="img-fluid">
                                            </div>
                                            <div
                                              class="cart-concern position-absolute">
                                              <div class="cart-button d-flex">
                                                <a href="#"
                                                  class="btn btn-medium btn-black">Add
                                                  to Cart<svg
                                                    class="cart-outline">
                                                    <use
                                                      xlink:href="#cart-outline">
                                                    </use>
                                                  </svg></a>
                                              </div>
                                            </div>
                                            <div
                                              class="card-detail d-flex justify-content-between pt-3">
                                              <h3
                                                class="card-title text-uppercase">
                                                <a href="#">black watch</a>
                                              </h3>
                                              <span
                                                class="item-price text-primary">$750</span>
                                            </div>
                                          </div>
                                        </div>
                                      </div>
                                    </div>
                                  </div>
                                </div>
                                <div
                                  class="swiper-pagination position-absolute text-center">
                                </div>
                                </section> --%>

                                <%-- inclue yearlySale component --%>
                                  <%@ include file="../component/yearlySale.jsp"
                                    %>

                                    <%-- inclue latestBlog component --%>
                                      <%@ include
                                        file="../component/latestBlog.jsp" %>

                                        <%-- <section id="testimonials"
                                          class="position-relative">
                                          <div class="container">
                                            <div class="row">
                                              <div
                                                class="review-content position-relative">
                                                <div
                                                  class="swiper-icon swiper-arrow swiper-arrow-prev position-absolute d-flex align-items-center">
                                                  <svg class="chevron-left">
                                                    <use
                                                      xlink:href="#chevron-left" />
                                                  </svg>
                                                </div>
                                                <div
                                                  class="swiper testimonial-swiper">
                                                  <div
                                                    class="quotation text-center">
                                                    <svg class="quote">
                                                      <use
                                                        xlink:href="#quote" />
                                                    </svg>
                                                  </div>
                                                  <div class="swiper-wrapper">
                                                    <div
                                                      class="swiper-slide text-center d-flex justify-content-center">
                                                      <div
                                                        class="review-item col-md-10">
                                                        <i
                                                          class="icon icon-review"></i>
                                                        <blockquote>“Tempus oncu
                                                          enim pellen tesque
                                                          este pretium in neque,
                                                          elit morbi sagittis
                                                          lorem habi mattis
                                                          Pellen tesque pretium
                                                          feugiat vel morbi
                                                          suspen dise sagittis
                                                          lorem habi tasse
                                                          morbi.”</blockquote>
                                                        <div class="rating">
                                                          <svg
                                                            class="star star-fill">
                                                            <use
                                                              xlink:href="#star-fill">
                                                            </use>
                                                          </svg>
                                                          <svg
                                                            class="star star-fill">
                                                            <use
                                                              xlink:href="#star-fill">
                                                            </use>
                                                          </svg>
                                                          <svg
                                                            class="star star-fill">
                                                            <use
                                                              xlink:href="#star-fill">
                                                            </use>
                                                          </svg>
                                                          <svg
                                                            class="star star-half">
                                                            <use
                                                              xlink:href="#star-half">
                                                            </use>
                                                          </svg>
                                                          <svg
                                                            class="star star-empty">
                                                            <use
                                                              xlink:href="#star-empty">
                                                            </use>
                                                          </svg>
                                                        </div>
                                                        <div
                                                          class="author-detail">
                                                          <div
                                                            class="name text-dark text-uppercase pt-2">
                                                            Emma Chamberlin
                                                          </div>
                                                        </div>
                                                      </div>
                                                    </div>
                                                    <div
                                                      class="swiper-slide text-center d-flex justify-content-center">
                                                      <div
                                                        class="review-item col-md-10">
                                                        <i
                                                          class="icon icon-review"></i>
                                                        <blockquote>“A blog is a
                                                          digital publication
                                                          that can complement a
                                                          website or exist
                                                          independently. A blog
                                                          may include articles,
                                                          short posts,
                                                          listicles,
                                                          infographics, videos,
                                                          and other digital
                                                          content.”</blockquote>
                                                        <div class="rating">
                                                          <svg
                                                            class="star star-fill">
                                                            <use
                                                              xlink:href="#star-fill">
                                                            </use>
                                                          </svg>
                                                          <svg
                                                            class="star star-fill">
                                                            <use
                                                              xlink:href="#star-fill">
                                                            </use>
                                                          </svg>
                                                          <svg
                                                            class="star star-fill">
                                                            <use
                                                              xlink:href="#star-fill">
                                                            </use>
                                                          </svg>
                                                          <svg
                                                            class="star star-half">
                                                            <use
                                                              xlink:href="#star-half">
                                                            </use>
                                                          </svg>
                                                          <svg
                                                            class="star star-empty">
                                                            <use
                                                              xlink:href="#star-empty">
                                                            </use>
                                                          </svg>
                                                        </div>
                                                        <div
                                                          class="author-detail">
                                                          <div
                                                            class="name text-dark text-uppercase pt-2">
                                                            Jennie Rose</div>
                                                        </div>
                                                      </div>
                                                    </div>
                                                  </div>
                                                </div>
                                                <div
                                                  class="swiper-icon swiper-arrow swiper-arrow-next position-absolute d-flex align-items-center">
                                                  <svg class="chevron-right">
                                                    <use
                                                      xlink:href="#chevron-right" />
                                                  </svg>
                                                </div>
                                              </div>
                                            </div>
                                          </div>
                                          <div class="swiper-pagination"></div>
                                          </section> --%>

                                          <section id="subscribe"
                                            class="container-grid padding-large position-relative overflow-hidden">
                                            <div class="container">
                                              <div class="row">
                                                <div
                                                  class="subscribe-content bg-dark d-flex flex-wrap justify-content-center align-items-center padding-medium">
                                                  <div
                                                    class="col-md-6 col-sm-12">
                                                    <div
                                                      class="display-header pe-3">
                                                      <h2
                                                        class="display-7 text-uppercase text-light">
                                                        Subscribe Us Now</h2>
                                                      <p>Get latest news,
                                                        updates and deals
                                                        directly mailed to your
                                                        inbox.</p>
                                                    </div>
                                                  </div>
                                                  <div
                                                    class="col-md-5 col-sm-12">
                                                    <form
                                                      class="subscription-form validate">
                                                      <div
                                                        class="input-group flex-wrap">
                                                        <input
                                                          class="form-control btn-rounded-none"
                                                          type="email"
                                                          name="EMAIL"
                                                          placeholder="Your email address here"
                                                          required="">
                                                        <button
                                                          class="btn btn-medium btn-primary text-uppercase btn-rounded-none"
                                                          type="submit"
                                                          name="subscribe">Subscribe</button>
                                                      </div>
                                                    </form>
                                                  </div>
                                                </div>
                                              </div>
                                            </div>
                                          </section>

                                          <%-- <section id="instagram"
                                            class="padding-large overflow-hidden no-padding-top">
                                            <div class="container">
                                              <div class="row">
                                                <div
                                                  class="display-header text-uppercase text-dark text-center pb-3">
                                                  <h2 class="display-7">Shop Our
                                                    Insta</h2>
                                                </div>
                                                <div class="d-flex flex-wrap">
                                                  <figure
                                                    class="instagram-item pe-2">
                                                    <a href="https://templatesjungle.com/"
                                                      class="image-link position-relative">
                                                      <img
                                                        src="images/insta-item1.jpg"
                                                        alt="instagram"
                                                        class="insta-image">
                                                      <div
                                                        class="icon-overlay position-absolute d-flex justify-content-center">
                                                        <svg class="instagram">
                                                          <use
                                                            xlink:href="#instagram">
                                                          </use>
                                                        </svg>
                                                      </div>
                                                    </a>
                                                  </figure>
                                                  <figure
                                                    class="instagram-item pe-2">
                                                    <a href="https://templatesjungle.com/"
                                                      class="image-link position-relative">
                                                      <img
                                                        src="images/insta-item2.jpg"
                                                        alt="instagram"
                                                        class="insta-image">
                                                      <div
                                                        class="icon-overlay position-absolute d-flex justify-content-center">
                                                        <svg class="instagram">
                                                          <use
                                                            xlink:href="#instagram">
                                                          </use>
                                                        </svg>
                                                      </div>
                                                    </a>
                                                  </figure>
                                                  <figure
                                                    class="instagram-item pe-2">
                                                    <a href="https://templatesjungle.com/"
                                                      class="image-link position-relative">
                                                      <img
                                                        src="images/insta-item3.jpg"
                                                        alt="instagram"
                                                        class="insta-image">
                                                      <div
                                                        class="icon-overlay position-absolute d-flex justify-content-center">
                                                        <svg class="instagram">
                                                          <use
                                                            xlink:href="#instagram">
                                                          </use>
                                                        </svg>
                                                      </div>
                                                    </a>
                                                  </figure>
                                                  <figure
                                                    class="instagram-item pe-2">
                                                    <a href="https://templatesjungle.com/"
                                                      class="image-link position-relative">
                                                      <img
                                                        src="images/insta-item4.jpg"
                                                        alt="instagram"
                                                        class="insta-image">
                                                      <div
                                                        class="icon-overlay position-absolute d-flex justify-content-center">
                                                        <svg class="instagram">
                                                          <use
                                                            xlink:href="#instagram">
                                                          </use>
                                                        </svg>
                                                      </div>
                                                    </a>
                                                  </figure>
                                                  <figure
                                                    class="instagram-item pe-2">
                                                    <a href="https://templatesjungle.com/"
                                                      class="image-link position-relative">
                                                      <img
                                                        src="images/insta-item5.jpg"
                                                        alt="instagram"
                                                        class="insta-image">
                                                      <div
                                                        class="icon-overlay position-absolute d-flex justify-content-center">
                                                        <svg class="instagram">
                                                          <use
                                                            xlink:href="#instagram">
                                                          </use>
                                                        </svg>
                                                      </div>
                                                    </a>
                                                  </figure>
                                                </div>
                                              </div>
                                            </div>
                                            </section> --%>

                                            <%-- inclue footer component --%>
                                              <%@ include
                                                file="../component/footer.jsp"
                                                %>

                                                <footer id="footer"
                                                  class="overflow-hidden">
                                                  <div class="container">
                                                    <div class="row">
                                                      <div
                                                        class="footer-top-area">
                                                        <div
                                                          class="row d-flex flex-wrap justify-content-between">
                                                          <div
                                                            class="col-lg-3 col-sm-6 pb-3">
                                                            <div
                                                              class="footer-menu">
                                                              <img
                                                                src="${pageContext.request.contextPath}/view/resources/images/main-logo.png"
                                                                alt="logo">
                                                              <p>Nisi, purus
                                                                vitae, ultrices
                                                                nunc. Sit ac sit
                                                                suscipit
                                                                hendrerit.
                                                                Gravida massa
                                                                volutpat aenean
                                                                odio erat nullam
                                                                fringilla.</p>
                                                              <div
                                                                class="social-links">
                                                                <ul
                                                                  class="d-flex list-unstyled">
                                                                  <li>
                                                                    <a href="#">
                                                                      <svg
                                                                        class="facebook">
                                                                        <use
                                                                          xlink:href="#facebook" />
                                                                      </svg>
                                                                    </a>
                                                                  </li>
                                                                  <li>
                                                                    <a href="#">
                                                                      <svg
                                                                        class="instagram">
                                                                        <use
                                                                          xlink:href="#instagram" />
                                                                      </svg>
                                                                    </a>
                                                                  </li>
                                                                  <li>
                                                                    <a href="#">
                                                                      <svg
                                                                        class="twitter">
                                                                        <use
                                                                          xlink:href="#twitter" />
                                                                      </svg>
                                                                    </a>
                                                                  </li>
                                                                  <li>
                                                                    <a href="#">
                                                                      <svg
                                                                        class="linkedin">
                                                                        <use
                                                                          xlink:href="#linkedin" />
                                                                      </svg>
                                                                    </a>
                                                                  </li>
                                                                  <li>
                                                                    <a href="#">
                                                                      <svg
                                                                        class="youtube">
                                                                        <use
                                                                          xlink:href="#youtube" />
                                                                      </svg>
                                                                    </a>
                                                                  </li>
                                                                </ul>
                                                              </div>
                                                            </div>
                                                          </div>
                                                          <div
                                                            class="col-lg-2 col-sm-6 pb-3">
                                                            <div
                                                              class="footer-menu text-uppercase">
                                                              <h5
                                                                class="widget-title pb-2">
                                                                Quick Links</h5>
                                                              <ul
                                                                class="menu-list list-unstyled text-uppercase">
                                                                <li
                                                                  class="menu-item pb-2">
                                                                  <a
                                                                    href="#">Home</a>
                                                                </li>
                                                                <li
                                                                  class="menu-item pb-2">
                                                                  <a
                                                                    href="#">About</a>
                                                                </li>
                                                                <li
                                                                  class="menu-item pb-2">
                                                                  <a
                                                                    href="#">Shop</a>
                                                                </li>
                                                                <li
                                                                  class="menu-item pb-2">
                                                                  <a
                                                                    href="#">Blogs</a>
                                                                </li>
                                                                <li
                                                                  class="menu-item pb-2">
                                                                  <a
                                                                    href="#">Contact</a>
                                                                </li>
                                                              </ul>
                                                            </div>
                                                          </div>
                                                          <div
                                                            class="col-lg-3 col-sm-6 pb-3">
                                                            <div
                                                              class="footer-menu text-uppercase">
                                                              <h5
                                                                class="widget-title pb-2">
                                                                Help & Info Help
                                                              </h5>
                                                              <ul
                                                                class="menu-list list-unstyled">
                                                                <li
                                                                  class="menu-item pb-2">
                                                                  <a href="#">Track
                                                                    Your
                                                                    Order</a>
                                                                </li>
                                                                <li
                                                                  class="menu-item pb-2">
                                                                  <a href="#">Returns
                                                                    Policies</a>
                                                                </li>
                                                                <li
                                                                  class="menu-item pb-2">
                                                                  <a href="#">Shipping
                                                                    +
                                                                    Delivery</a>
                                                                </li>
                                                                <li
                                                                  class="menu-item pb-2">
                                                                  <a href="#">Contact
                                                                    Us</a>
                                                                </li>
                                                                <li
                                                                  class="menu-item pb-2">
                                                                  <a
                                                                    href="#">Faqs</a>
                                                                </li>
                                                              </ul>
                                                            </div>
                                                          </div>
                                                          <div
                                                            class="col-lg-3 col-sm-6 pb-3">
                                                            <div
                                                              class="footer-menu contact-item">
                                                              <h5
                                                                class="widget-title text-uppercase pb-2">
                                                                Contact Us</h5>
                                                              <p>Do you have any
                                                                queries or
                                                                suggestions? <a
                                                                  href="mailto:">yourinfo@gmail.com</a>
                                                              </p>
                                                              <p>If you need
                                                                support? Just
                                                                give us a call.
                                                                <a href="">+55
                                                                  111
                                                                  222 333 44</a>
                                                              </p>
                                                            </div>
                                                          </div>
                                                          <div
                                                            class="copyright">
                                                            <p>© Copyright 2023
                                                              MiniStore. Design
                                                              by <a
                                                                href="https://templatesjungle.com/">TemplatesJungle</a>
                                                              Distribution by <a
                                                                href="https://themewagon.com">ThemeWagon</a>
                                                            </p>
                                                          </div>
                                                        </div>
                                                      </div>
                                                    </div>
                                                    <hr>
                                                </footer>

                                                <%-- inclue footer component
                                                  --%>
                                                  <%@ include
                                                    file="../component/footer.jsp"
                                                    %>

                                                    <%-- <div
                                                      id="footer-bottom">
                                                      <div class="container">
                                                        <div
                                                          class="row d-flex flex-wrap justify-content-between">
                                                          <div
                                                            class="col-md-4 col-sm-6">
                                                            <div
                                                              class="Shipping d-flex">
                                                              <p>We ship with:
                                                              </p>
                                                              <div
                                                                class="card-wrap ps-2">
                                                                <img
                                                                  src="images/dhl.png"
                                                                  alt="visa">
                                                                <img
                                                                  src="images/shippingcard.png"
                                                                  alt="mastercard">
                                                              </div>
                                                            </div>
                                                          </div>
                                                          <div
                                                            class="col-md-4 col-sm-6">
                                                            <div
                                                              class="payment-method d-flex">
                                                              <p>Payment
                                                                options:
                                                              </p>
                                                              <div
                                                                class="card-wrap ps-2">
                                                                <img
                                                                  src="images/visa.jpg"
                                                                  alt="visa">
                                                                <img
                                                                  src="images/mastercard.jpg"
                                                                  alt="mastercard">
                                                                <img
                                                                  src="images/paypal.jpg"
                                                                  alt="paypal">
                                                              </div>
                                                            </div>
                                                          </div>
                                                          <div
                                                            class="col-md-4 col-sm-6">
                                                            <div
                                                              class="copyright">
                                                              <p>© Copyright
                                                                2023
                                                                MiniStore.
                                                                Design by
                                                                <a
                                                                  href="https://templatesjungle.com/">TemplatesJungle</a>
                                                                Distribution by
                                                                <a
                                                                  href="https://themewagon.com">ThemeWagon</a>
                                                              </p>
                                                            </div>
                                                          </div>
                                                        </div>
                                                      </div>
                                                      </div> --%>
                                                      <script
                                                        src="${pageContext.request.contextPath}/view/resources/js/jquery-1.11.0.min.js"></script>
                                                      <script
                                                        src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>
                                                      <script
                                                        type="text/javascript"
                                                        src="${pageContext.request.contextPath}/view/resources/js/bootstrap.bundle.min.js"></script>
                                                      <script
                                                        type="text/javascript"
                                                        src="${pageContext.request.contextPath}/view/resources/js/plugins.js"></script>
                                                      <script
                                                        type="text/javascript"
                                                        src="${pageContext.request.contextPath}/view/resources/js/script.js"></script>
        </body>

      </html>