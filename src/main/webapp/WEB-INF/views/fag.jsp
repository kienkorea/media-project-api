<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>게시판</title>

    <!-- plugins -->
    <link rel="stylesheet" href="<c:url value='/template/web/css/plugins.css' />"/>
    <link rel="stylesheet" href="<c:url value='/' />"/>

    <!-- core style css -->
    <link href="<c:url value='/template/web/css/styles.css' />" rel="stylesheet"/>

    <%--jquery 1.12.4--%>
    <script type='text/javascript' src='<c:url value="/template/web/js/jquery.min.js" />'></script>
</head>

<body>


<!-- start footer section -->

<footer>
    <div class="footer-style3-top">
        <div class="container">

            <div class="row align-items-center">

                <div class="col-md-7 sm-margin-20px-bottom">

                    <h5 class="margin-5px-bottom text-white">Subscribe to our Newsletter!</h5>

                    <p>Sign up for our newsletter and follow us on social media.</p>

                </div>

                <div class="col-md-5">

                    <div class="email-box">

                        <div class="input">

                            <form>

                                <input type="email" placeholder="Enter Email" class="no-margin-bottom">

                                <button class="butn">Subscribe</button>

                            </form>

                        </div>

                    </div>

                </div>

            </div>

        </div>

    </div>

    <div class="container">

        <div class="footer-5 footer-style3">

            <div class="row">

                <div class="col-lg-3 col-md-6 sm-margin-25px-bottom mobile-margin-20px-bottom">

                    <div class="sm-padding-50px-right xs-no-padding-right">

                                <span class="footer-logo margin-25px-bottom xs-margin-15px-bottom display-inline-block">

                                    <img src="img/logos/logo-footer-small-white.png" alt="logo">

                                </span>

                        <p class="no-margin-bottom">Lorem ipsum dolor consectetur consectetur adipiscing ipsum dolor
                            consectetur adipiscing sed et eletum nulla.</p>

                    </div>

                </div>


                <div class="col-lg-3 col-sm-6 sm-margin-25px-bottom mobile-margin-20px-bottom">

                    <div class="padding-70px-left md-padding-50px-left sm-no-padding-left">

                        <h4 class="mobile-margin-10px-bottom">Popular Search</h4>

                        <ul class="footer-list no-margin-bottom">

                            <li><a href="javascript:void(0)" class="font-size14">Property for Rent</a></li>

                            <li><a href="javascript:void(0)" class="font-size14">Property for Sale</a></li>

                            <li><a href="javascript:void(0)" class="font-size14">Resale Properties</a></li>

                            <li><a href="javascript:void(0)" class="font-size14">Recent Properties</a></li>

                        </ul>

                    </div>

                </div>


                <div class="col-lg-3 col-sm-6 mobile-margin-20px-bottom">

                    <div class="padding-40px-left sm-no-padding-left">

                        <h4 class="mobile-margin-10px-bottom">Quick Links</h4>

                        <ul class="footer-list no-margin-bottom">

                            <li><a href="javascript:void(0)" class="font-size14">About us</a></li>

                            <li><a href="javascript:void(0)" class="font-size14">Contact us</a></li>

                            <li><a href="javascript:void(0)" class="font-size14">Privacy Policy</a></li>

                            <li><a href="javascript:void(0)" class="font-size14">FAQ</a></li>

                        </ul>

                    </div>

                </div>


                <div class="col-lg-3 col-md-6">

                    <h4 class="mobile-margin-10px-bottom">Quick Contact</h4>

                    <ul class="">

                        <li><i class="ti-location-pin margin-10px-right md-margin-two-right text-theme-color"></i>27
                            Division St, New York, USA
                        </li>

                        <li><a href="javascript:void(0)" class="font-size14"><i
                                class="ti-email margin-10px-right md-margin-two-right text-theme-color"></i>your@name.gmail.com</a>
                        </li>

                        <li><i class="ti-mobile margin-10px-right md-margin-two-right text-theme-color"></i>(+44) 123
                            456 789
                        </li>

                    </ul>


                    <div class="footer-icon">

                        <ul class="no-margin-bottom">

                            <li>

                                <a href="javascript:void(0)"><i class="fab fa-facebook-f"></i></a>

                            </li>

                            <li>

                                <a href="javascript:void(0)"><i class="fab fa-twitter"></i></a>

                            </li>

                            <li>

                                <a href="javascript:void(0)"><i class="fab fa-youtube "></i></a>

                            </li>

                            <li>

                                <a href="javascript:void(0)"><i class="fab fa-linkedin-in"></i></a>

                            </li>

                        </ul>

                    </div>

                </div>

            </div>

        </div>

    </div>

    <div class="footer-style3-bottom">

        <div class="container">

            <p class="font-size14">&copy; 2020 Structure is Powered by Chitrakoot Web</p>

        </div>

    </div>

</footer>

<!-- end footer section -->
</body>

</html>