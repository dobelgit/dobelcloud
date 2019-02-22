package main

import (
    "fmt"
    "io/ioutil"
    "log"
    "net/http"
    "net/http/httputil"
    "net/url"
)

func main() {

    //creating the proxyURL
    proxyStr := "http://域名:端口"
    proxyURL, err := url.Parse(proxyStr)
    proxyURL.User = url.UserPassword("账号", "密码")
    if err != nil {
        log.Println(err)
    }




    //creating the URL to be loaded through the proxy
    urlStr := "https://www.taobao.com/help/getip.php"
    url, err := url.Parse(urlStr)
    if err != nil {
        log.Println(err)
    }

    //adding the proxy settings to the Transport object
    transport := &http.Transport{
        Proxy: http.ProxyURL(proxyURL),
    }

    //adding the Transport object to the http Client
    client := &http.Client{
        Transport: transport,
    }

    //generating the HTTP GET request
    request, err := http.NewRequest("GET", url.String(), nil)
    if err != nil {
        log.Println(err)
    }

  //adding header for close keepalive
    connection := "closed"
    request.Header.Add("Connection", connection)

    //printing the request to the console
    dump, _ := httputil.DumpRequest(request, false)
    fmt.Println(string(dump))

    //calling the URL
    response, err := client.Do(request)
    if err != nil {
        log.Println(err)
    }

    log.Println(response.StatusCode)
    log.Println(response.Status)
    //getting the response
    data, err := ioutil.ReadAll(response.Body)
    if err != nil {
        log.Println(err)
    }
    //printing the response
    log.Println(string(data))

    //calling the URL
    response1, err := client.Do(request)
    if err != nil {
        log.Println(err)
    }

    log.Println(response1.StatusCode)
    log.Println(response1.Status)
    //getting the response
    data1, err := ioutil.ReadAll(response1.Body)
    if err != nil {
        log.Println(err)
    }
    //printing the response
    log.Println(string(data1))
}
