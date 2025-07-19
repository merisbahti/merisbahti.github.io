(ns gen-html
  (:require
   [hiccup.page :refer [html5]]
   [hiccup2.core :as h]))

(def document
  (list
   [:head
    [:meta {:charset "UTF-8"}]
    [:meta {:name "viewport", :content "width=device-width, initial-scale=1.0"}]
    [:link
     {:rel "icon",
      :href
      "data:image/svg+xml,<svg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 100 100'><circle cx='50' cy='50' r='50' fill='%23007bff'/><text x='50' y='55' font-family='Arial, sans-serif' font-size='50' fill='%23ffffff' text-anchor='middle' dominant-baseline='middle'>MB</text></svg>",
      :type "image/svg+xml"}]
    [:link {:rel "stylesheet"
            :href "style.css"}]
    [:script {:defer true}
     "const b64email = \"bWVyaXMuYmFodGlAZ21haWwuY29t\";
const b64phone = \"KzQ2IDczMyA4NiAxMSAxMw==\";
requestAnimationFrame(() => {
   document.querySelector(\"#hidden-email\").innerText = `Email: ${atob(
     b64email,
   )}`;
   document.querySelector(\"#hidden-phone\").innerText = `Phone: ${atob(
    b64phone,
   )}`;
 });
"]]

   [:body
    [:main
     [:section
      [:h1 "Meris Bahtijaragic"]
      [:ul.title
       [:li "Senior Software Developer"]
       [:li "MSc. Computer Science"]]
      [:ul.title
       [:li#hidden-email "Email: HIDDEN"]
       [:li#hidden-phone "Phone: HIDDEN"]]
      [:p
       [:a
        {:href "https://www.linkedin.com/in/meris-bahtijaragic/"}
        "linkedin.com/in/meris-bahtijaragic/"]]
      [:p
       [:a {:href "https://github.com/merisbahti"} "github.com/merisbahti"]]]
     [:section
      [:h2 "Professional Summary"]
      [:p
       "A passionate Senior Software Developer with a MSc in Computer Science. I'm versatile, with extensive experience in both frontend, backend, and data engineering. I value communication with stakeholders and mentoring of other developers as much as delivering the final working product. I enjoy leading software development, improving code quality and creating tools for development, performance optimization and applying security best practices."]]
     [:section
      [:h2 "Skills"]
      [:ul.tags
       [:li "TypeScript"]
       [:li "JavaScript"]
       [:li "Node.js"]
       [:li "Functional Programming"]
       [:li "Docker"]
       [:li "SQL"]
       [:li "Git"]
       [:li "Scala"]
       [:li "Svelte"]
       [:li "Algorithms"]
       [:li "React"]
       [:li "Mentoring"]
       [:li "Software Architecture"]
       [:li "Continuous Integration (CI)"]
       [:li "Continuous Delivery (CD)"]
       [:li "Java"]
       [:li "Python"]]]
     [:section.experience
      [:h2 "Professional Experience"]
      [:article
       [:h3 "StickerApp AB - Full-stack Developer"]
       [:p "Lomma, March 2024 - June 2025"]
       [:p "Assignment with StickerApp"]
       [:ul
        [:li
         "Worked closely with the content production team to develop a full global CMS solution deployed to 12+ markets."]
        [:li
         "Established easy to follow code standards and automated them with tools such as TypeScript, eslint and GitHub actions."]]
       [:ul.tags
        [:li "Svelte"]
        [:li "Docker"]
        [:li "Redis"]
        [:li "TypeScript"]]]
      [:article
       [:h3 "Apple Maps - Full-stack Developer"]
       [:p "Malmö, March 2023 - March 2024"]
       [:p "Assignment with Apple Maps"]
       [:ul.tags
        [:li "Scala"]
        [:li "Apache Spark"]
        [:li "Big Data"]
        [:li "Python"]
        [:li "React"]
        [:li "Node.js"]
        [:li "Java"]
        [:li "Typescript"]]]
      [:article
       [:h3 "Spotify AB - Senior Security Engineer"]
       [:p "Remote, April 2021 - March 2023"]
       [:p "Assignment and employment with Spotify"]
       [:ul
        [:li "Developed the product called Backstage, with a focus on security."]
        [:li
         "Applied my knowledge of security to build automated tools to help developers write secure code."]
        [:li "Consulted on security incidents."]
        [:li
         "Increased the maintainability of their data pipelines using Scio, Flyte, Luigi, and Airflow."]]
       [:ul.tags
        [:li "Scala"]
        [:li "Luigi"]
        [:li "Scio"]
        [:li "Airflow"]
        [:li "React"]
        [:li "Node.js"]
        [:li "Java"]
        [:li "Python"]
        [:li "Typescript"]
        [:li "Google Cloud"]
        [:li "BigQuery"]]]
      [:article
       [:h3 "Apple Maps - Frontend developer"]
       [:p "Malmö, October 2019 - April 2021"]
       [:p "Assignment with Apple Maps"]
       [:ul
        [:li
         "Served as a software architect, responsible for CI, code health, and development of code."]]
       [:ul.tags
        [:li "Scala"]
        [:li "React"]
        [:li "Typescript"]
        [:li "Node.js"]
        [:li "Java"]]]
      [:article
       [:h3 "Prisjakt Sverige AB - Software Developer"]
       [:p "Malmö, February 2019 - October 2019"]
       [:ul
        [:li
         "Improved the developer experience by creating developer tools, guidelines, and a KPI dashboard."]
        [:li
         "Measured and improved the runtime performance of the React application."]
        [:li
         "Integrated TypeScript into existing non-trivial parts of the system and development workflow."]]
       [:ul.tags
        [:li "React"]
        [:li "Typescript"]
        [:li "Node.js"]
        [:li "Java"]]]
      [:article
       [:h3 "TrueSec - Cyber Security Software Developer"]
       [:p "Malmö, February 2018 - February 2019"]
       [:ul
        [:li
         "Development of a web-application vulnerability scanning server service."]
        [:li
         "Maintenance and deployment of a web application firewall product."]
        [:li
         "Performed varied tasks ranging from API and web development to server operations and security consulting."]]
       [:ul.tags
        [:li "React"]
        [:li "Typescript"]
        [:li "Node.js"]
        [:li "Java"]
        [:li "GitLab"]]]
      [:article
       [:h3 "Digifort AB - Software Developer"]
       [:p "Lund, April 2014 - February 2018"]
       [:ul
        [:li
         "Main focus was developing a web-application security monitoring platform."]
        [:li
         "Performed varied tasks ranging from API and web development to server operations and databases."]]
       [:ul.tags
        [:li "React"]
        [:li "Typescript"]
        [:li "Node.js"]
        [:li "Java"]
        [:li "GitLab"]]]]
     [:section
      [:h2 "Personal Projects"]
      [:article
       [:h3 "Lisp(ish) compiler and VM"]
       [:p
        "I developed a LISP compiler and virtual machine in Rust for educational purposes. The VM compiler supports WASM and each instruction can be stepped through in a visual tool. It even has support for compile-time macros."]
       [:p
        [:a
         {:href "https://github.com/merisbahti/rust-lisp-wasm"}
         "https://github.com/merisbahti/rust-lisp-wasm"]]]
      [:article
       [:h3 "Efficient state management in React"]
       [:p
        "Developed a highly efficient state management library in react. It is an exploration of functional lenses and performant real-time edits of huge data structures."]
       [:p
        [:a
         {:href "https://github.com/merisbahti/klyva"}
         "https://github.com/merisbahti/klyva"]]]]
     [:section.education
      [:h2 "Education"]
      [:h3 "Master of Science in Computer Science and Engineering"]
      [:p "Lunds Tekniska Högskola | Lund, Skåne | 2011 - 2016"]
      [:p "Thesis: Intrusion Detection System by Statistical Learning"]
      [:p "Trained an AI to classify hacking attempts."]
      [:a
       {:href "https://lup.lub.lu.se/student-papers/search/publication/8887271"}
       "lup.lub.lu.se/student-papers/search/publication/8887271"]]]]))

(defn main []
  (spit "myhtml.html" (str (html5 (h/html document)))))
